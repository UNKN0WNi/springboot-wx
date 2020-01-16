package com.wxpublic.domain;

import com.wxpublic.Utils.WeChatContant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoiceMessage extends BaseMessage {

    private MediaId Voice;

    private String MsgType= WeChatContant.REQ_MESSAGE_TYPE_VOICE;
}