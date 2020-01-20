package com.wxpublic.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangyaoliang
 * @since 2020-01-19 16:44
 */
@Getter
@Setter
public class AccessTokenVO {


    private String access_token;


    private int expires_in;

}
