package com.xiaoyilin.domain;

import com.xiaoyilin.Utils.WeChatContant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MusicMessage extends BaseMessage {

    private Music Music;

    private String MsgType= WeChatContant.REQ_MESSAGE_TYPE_MUSIC;
}