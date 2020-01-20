package com.wxpublic.wxEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuType {

    // 点击式菜单
    CLICK("click"),
    // 链接式菜单
    VIEW("view");

    private String type;

    public String getType() {
        return type;
    }
}
