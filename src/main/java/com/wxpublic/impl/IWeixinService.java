package com.wxpublic.impl;

import com.wxpublic.domain.AccessTokenVO;

/**
 * @author zhangyaoliang
 * @since 2020-01-19 16:43
 */
public interface IWeixinService {

    /**
     * 根据AppID和AppSecret获取access_token
     *
     * @param appId:
     * @param appSecret:
     * @return: com.zhengqing.demo.modules.weixin.model.AccessTokenVO
     */
    AccessTokenVO getAccessToken(String appId, String appSecret);

}


