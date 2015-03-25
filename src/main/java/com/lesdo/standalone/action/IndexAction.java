package com.lesdo.standalone.action;

import com.lesdo.standalone.service.UserService;
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

        userService.sayHello();

        LogUtil.getLogger("sxy").info("==================233");
        getResponse().getWriter().write("1111111111111111");
//        return SUCCESS;
//        return "login2";
//        Launch.destory();
        return NONE;
//        return "redirect";
    }
}
