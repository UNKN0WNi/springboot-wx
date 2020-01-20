package com.wxpublic;

import com.wxpublic.config.Constants;
import com.wxpublic.domain.AccessTokenVO;
import com.wxpublic.domain.WeixinResponseResult;
import com.wxpublic.domain.menu.*;
import com.wxpublic.impl.IMenuService;
import com.wxpublic.impl.IWeixinService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class WeixinTest {

    @Autowired
    private IWeixinService weixinService;

    @Autowired
    private IMenuService menuService;


    public String getAccessToken() {
        AccessTokenVO accessTokenVO = weixinService.getAccessToken(Constants.APP_ID, Constants.APP_SECRET);
        log.info("======================================== \n" + accessTokenVO.getAccess_token());
        return accessTokenVO.getAccess_token();
    }


    @Test
    public void createMenu() {
        String token=getAccessToken();
        WeixinResponseResult result = menuService.createMenu(createMenuTree(), token);
        log.info("======================================== \n" + result);
    }

    /**
     * 菜单数据
     */
    private Menu createMenuTree() {
        // 链接式菜单
        ViewButton btn11 = new ViewButton();
        btn11.setName("CSDN");
        btn11.setUrl("https://zhengqing.blog.csdn.net/");

        ViewButton btn12 = new ViewButton();
        btn12.setName("个人博客");
        btn12.setUrl("http://zhengqingya.gitee.io/blog/");

        // 点击式菜单
        ClickButton mainBtn2 = new ClickButton();
        mainBtn2.setName("点我吖");
        mainBtn2.setKey("hello");

        ViewButton btn31 = new ViewButton();
        btn31.setName("码云");
        btn31.setUrl("https://gitee.com/zhengqingya/projects");

        ViewButton btn32 = new ViewButton();
        btn32.setName("GitHub");
        btn32.setUrl("https://github.com/zhengqingya?tab=repositories");

        // 含二级菜单的一级菜单
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("博客");
        mainBtn1.setSub_button(new ViewButton[]{btn11, btn12});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("仓库");
        mainBtn3.setSub_button(new ViewButton[]{btn31, btn32});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});

        return menu;
    }


}


