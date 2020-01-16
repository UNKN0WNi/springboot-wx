package com.xiaoyilin.domain;

import com.xiaoyilin.Utils.WeChatContant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoiceMessage extends BaseMessage {

    private MediaId Voice;

    private String MsgType= WeChatContant.REQ_MESSAGE_TYPE_VOICE;
}