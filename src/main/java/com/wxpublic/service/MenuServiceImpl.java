package com.wxpublic.service;

import com.google.gson.Gson;
import com.wxpublic.Utils.GsonUtil;
import com.wxpublic.config.Constants;
import com.wxpublic.domain.WeixinResponseResult;
import com.wxpublic.domain.menu.Menu;
import com.wxpublic.impl.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangyaoliang
 * @since 2020-01-19 17:10
 */
@Slf4j
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Object getMenu(String accessToken) {
        Object menu = restTemplate.getForObject(Constants.GET_MENU_URL.replace("ACCESS_TOKEN", accessToken), Object.class);
        return menu;
    }

    @Override
    public WeixinResponseResult deleteMenu(String accessToken) {
        WeixinResponseResult result = restTemplate.getForObject(Constants.DELETE_MENU_URL.replace("ACCESS_TOKEN", accessToken), WeixinResponseResult.class);
        return result;
    }

    @Override
    public WeixinResponseResult createMenu(Menu menu, String accessToken) {
        // 将菜单对象转换成json字符串
        String jsonMenu = GsonUtil.GsonString(menu);
        WeixinResponseResult result = restTemplate.postForObject(Constants.CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken), jsonMenu, WeixinResponseResult.class);
        return result;
    }

}
