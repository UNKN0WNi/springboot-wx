package com.xiaoyilin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangyaoliang
 * @since 2020-01-15 17:53
 */

@Setter
@Getter
@AllArgsConstructor
public class Music {
    private String Title;
    private String Description;
    private String MusicUrl;
    private String HQMusicUrl;
    private String ThumbMediaId;
}
