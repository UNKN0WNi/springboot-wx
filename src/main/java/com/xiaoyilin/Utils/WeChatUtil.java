package com.xiaoyilin.Utils;

import com.thoughtworks.xstream.XStream;
import com.xiaoyilin.domain.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * 请求校验工具类
 *
 * @author 32950745
 */
public class WeChatUtil {

    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{WeChatContant.TOKEN, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
        // Arrays.sort(arr);
        sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

    private static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 解析微信发来的请求(xml)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"unchecked"})
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }

    public static String mapToXML(Map map) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        mapToXML2(map, sb);
        sb.append("</xml>");
        try {
            return sb.toString();
        } catch (Exception e) {
        }
        return null;
    }

    private static void mapToXML2(Map map, StringBuffer sb) {
        Set set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (null == value) {
                value = "";
            }
            if (value.getClass().getName().equals("java.util.ArrayList")) {
                ArrayList list = (ArrayList) map.get(key);
                sb.append("<" + key + ">");
                for (int i = 0; i < list.size(); i++) {
                    HashMap hm = (HashMap) list.get(i);
                    mapToXML2(hm, sb);
                }
                sb.append("</" + key + ">");

            } else {
                if (value instanceof HashMap) {
                    sb.append("<" + key + ">");
                    mapToXML2((HashMap) value, sb);
                    sb.append("</" + key + ">");
                } else {
                    sb.append("<" + key + "><![CDATA[" + value + "]]></" + key + ">");
                }

            }

        }
    }

    /**
     * 回复文本消息
     *
     * @param requestMap
     * @param content
     * @return
     */
    public static String sendTextMsg(Map<String, String> requestMap, String content) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ToUserName", requestMap.get(WeChatContant.FromUserName));
        map.put("FromUserName", requestMap.get(WeChatContant.ToUserName));
        map.put("MsgType", WeChatContant.RESP_MESSAGE_TYPE_TEXT);
        map.put("CreateTime", System.currentTimeMillis());
        map.put("Content", content);
        return mapToXML(map);
    }



    public static String sendImageMsg(Map<String, String> requestMap) {

        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setFromUserName(requestMap.get(WeChatContant.ToUserName));
        imageMessage.setToUserName(requestMap.get(WeChatContant.FromUserName));
        imageMessage.setCreateTime(System.currentTimeMillis());
        imageMessage.setImage(new MediaId("tut0e2CdzkjQlzrvCyXM0KzT7pjJobL66W07EPIk8YtRA6mVqIzCh-EkYPdEFM6j"));


        XStream xStream = new XStream();
        xStream.alias("xml", imageMessage.getClass());
        return xStream.toXML(imageMessage);
    }

    public static String sendVideoMsg(Map<String, String> requestMap) {

        VideoMessage videoMessage = new VideoMessage();
        videoMessage.setFromUserName(requestMap.get(WeChatContant.ToUserName));
        videoMessage.setToUserName(requestMap.get(WeChatContant.FromUserName));
        videoMessage.setCreateTime(System.currentTimeMillis());
        videoMessage.setVideo(new Video("MTryNOSdi0fYb1IlMm3W_HTdKOAGDuXEBfBFvNrhLet7Wtu8HDjR9b0ACT5ctK8g","视频","一个视频"));


        XStream xStream = new XStream();
        xStream.alias("xml", videoMessage.getClass());
        return xStream.toXML(videoMessage);
    }

    public static String sendPicAndArticleMsg(Map<String, String> requestMap) {

        PicAndArticleMessage picAndArticleMessage = new PicAndArticleMessage();
        picAndArticleMessage.setFromUserName(requestMap.get(WeChatContant.ToUserName));
        picAndArticleMessage.setToUserName(requestMap.get(WeChatContant.FromUserName));
        picAndArticleMessage.setCreateTime(System.currentTimeMillis());
        picAndArticleMessage.setArticleCount(2);
        item item=new item("tile","desc","urlp","url");
        picAndArticleMessage.setArticles(new LinkedList());
        picAndArticleMessage.getArticles().add(new item("tile","desc","urlp","url"));
        picAndArticleMessage.getArticles().add(new item("tile","desc","urlp","url"));



        XStream xStream = new XStream();
        xStream.alias("xml", picAndArticleMessage.getClass());
        xStream.alias("item", item.getClass());
        xStream.alias("Articles", LinkedList.class);

        return xStream.toXML(picAndArticleMessage);
    }

    public static String sendMusicMsg(Map<String, String> requestMap) {

        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setFromUserName(requestMap.get(WeChatContant.ToUserName));
        musicMessage.setToUserName(requestMap.get(WeChatContant.FromUserName));
        musicMessage.setCreateTime(System.currentTimeMillis());
        musicMessage.setMusic(new Music("title","desc","http://sc1.111ttt.cn/2018/1/03/13/396131232171.mp3","http://sc1.111ttt.cn/2018/1/03/13/396131232171.mp3","5XYuzRVp167Edux4AXyBwf5y61Ai5FllHVXnRDUhqnCs2Z4uYLAWEWYqICKlsLHL"));


        XStream xStream = new XStream();
        xStream.alias("xml", musicMessage.getClass());
        return xStream.toXML(musicMessage);
    }

}