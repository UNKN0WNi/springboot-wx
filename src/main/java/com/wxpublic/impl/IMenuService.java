package com.wxpublic.impl;

import com.wxpublic.domain.WeixinResponseResult;
import com.wxpublic.domain.menu.Menu;

/**
 * @author zhangyaoliang
 * @since 2020-01-19 17:06
 */
public interface IMenuService {

    /**
     * 查询菜单
     *
     * @param accessToken:访问凭据
     * @return: java.lang.Object
     */
    Object getMenu(String accessToken);

    /**
     * 删除菜单
     *
     * @param accessToken:访问凭据
     * @return: com.zhengqing.demo.modules.weixin.model.WeixinResponseResult
     */
    WeixinResponseResult deleteMenu(String accessToken);

    /**
     * 创建菜单
     *
     * @param menu        : 创建的菜单数据
     * @param accessToken : 访问凭据
     * @return: com.zhengqing.demo.modules.weixin.model.WeixinResponseResult
     */
    WeixinResponseResult createMenu(Menu menu, String accessToken);

}

