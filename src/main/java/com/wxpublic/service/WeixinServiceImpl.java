package com.wxpublic.service;

import com.wxpublic.config.Constants;
import com.wxpublic.domain.AccessTokenVO;
import com.wxpublic.impl.IWeixinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 获取access token
 *
 * @author zhangyaoliang
 * @since 2020-01-19 16:42
 */
@Slf4j
@Service
public class WeixinServiceImpl   implements IWeixinService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AccessTokenVO getAccessToken(String appId, String appSecret) {
        AccessTokenVO accessTokenVO = restTemplate.getForObject(Constants.GET_ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret), AccessTokenVO.class);
        return accessTokenVO;
    }

}

