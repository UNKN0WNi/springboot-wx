package com.wxpublic.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * @desc  :链接消息
 */
@Setter
@Getter
public class LinkMessage extends BaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;


}