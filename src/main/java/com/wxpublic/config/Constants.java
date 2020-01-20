package com.wxpublic.config;

/**
 * 常量
 *
 * @author zhangyaoliang
 * @since 2020-01-19 16:40
 */
public class Constants {
    /**
     * TODO 填写自己的 `appID` 和 `appsecret`
     */
    public static final String APP_ID = "wx68d1f84ef31d9eba";
    public static final String APP_SECRET = "1fb4fdbdf909f230bd7230548ee1d2ac";

    /**
     * 通过 `GET请求方式` 获取 `access_token`
     */
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * TODO 只做临时方便测试使用
     */
    public static final String ACCESS_TOKEN = "29_RhU41zW1GD7RvJTC6W7G7FCsLqkmxAWGCkSkWBnYN1h8-PG4QM0GlSpk_FgzTLS1YZb0p2uAIn8DsM7oAEaoFIeYHJEv-eYwhmp8MGkcQ5EQUOWtwzK4Z2yZo7M5hvdmGHGOQ2aZX4BN9zgnAXLcAHAIFT";

    /**
     * 查询菜单接口 - GET请求
     */
    public static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    /**
     * 删除菜单接口 - GET请求 （注意，在个性化菜单时，调用此接口会删除默认菜单及全部个性化菜单）
     */
    public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    /**
     * 创建菜单接口 - POST请求
     */
    public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

}

