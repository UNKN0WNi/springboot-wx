package com.wxpublic.domain;

import com.wxpublic.Utils.WeChatContant;
import lombok.Getter;
import lombok.Setter;

/**
 * @desc  : 图片消息

 */
@Setter
@Getter
public class ImageMessage extends BaseMessage {
    // 图片链接
    private MediaId Image;

    private String MsgType= WeChatContant.REQ_MESSAGE_TYPE_IMAGE;
}