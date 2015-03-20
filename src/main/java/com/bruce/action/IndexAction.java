package com.bruce.action;

import com.syxy.service.UserService;
import org.jessma.ext.spring.SpringBean;
import org.jessma.mvc.ActionSupport;
import org.jessma.util.LogUtil;

import java.util.Date;

public class IndexAction extends ActionSupport {

    Date now;

    public Date getNow() {
        return now;
    }

    private UserService userService;

    @SpringBean("userService")
    @Override
    public String execute() throws Exception {
        now = new Date();
        System.out.println("==================222233");

        userService.sayHello();

        LogUtil.getJessMALogger().info("==================233");
        getResponse().getWriter().write("1111111111111111");
//        return SUCCESS;
//        return "login2";
        return NONE;
//        return "redirect";
    }
}
