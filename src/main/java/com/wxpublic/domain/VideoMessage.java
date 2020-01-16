package com.wxpublic.domain;

import com.wxpublic.Utils.WeChatContant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VideoMessage extends BaseMessage {

    private Video Video;

    private String MsgType= WeChatContant.REQ_MESSAGE_TYPE_VIDEO;
}