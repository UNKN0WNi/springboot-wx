package com.xiaoyilin.domain;

import com.xiaoyilin.Utils.WeChatContant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhangyaoliang
 * @since 2020-01-15 17:17
 */
@Getter
@Setter
public class  PicAndArticleMessage extends BaseMessage {
    //微信调整为只能为1条了
    int ArticleCount;
    List Articles;

    private String MsgType= WeChatContant.REQ_MESSAGE_TYPE_NEWS;
}
