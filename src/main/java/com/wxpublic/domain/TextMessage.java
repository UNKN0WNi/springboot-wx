package com.wxpublic.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @desc  : 文本消息
 *
 */
@Getter
@Setter
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

}