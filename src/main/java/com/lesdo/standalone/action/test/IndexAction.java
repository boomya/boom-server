package com.lesdo.standalone.action.test;

import com.lesdo.ext.spring.annotation.LocalServiceField;
import com.lesdo.standalone.service.CopywritingService;
import com.lesdo.standalone.service.UserService;
import org.jessma.mvc.ActionSupport;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;

import java.util.Date;

public class IndexAction extends ActionSupport {

    Date now;

    public Date getNow() {
        return now;
    }

    @LocalServiceField
    private UserService userService;

    private CopywritingService copywritingService;
    //    Logger logger = LogUtil.getJessMALogger();
    Logger logger = LogUtil.getLogger(IndexAction.class);

    //    @SpringBean("userService")
    @Override
    public String execute() throws Exception {
        now = new Date();

//        userService.sayHello();

        logger.info("==================233");
//        getResponse().getWriter().write("1111111111111111" + copywritingService.getWelcomeCopy());
        getResponse().getWriter().write("2222222222222");
//        return SUCCESS;
//        return "login2";
//        Launch.destory();
        return NONE;
//        return "redirect";
    }
}
