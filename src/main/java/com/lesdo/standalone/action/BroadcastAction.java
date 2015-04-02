package com.lesdo.standalone.action;

import com.lesdo.standalone.service.BroadcastService;
import com.lesdo.standalone.service.CopywritingService;
import com.lesdo.standalone.service.LocalServiceLocator;
import com.lesdo.standalone.service.UserService;
import org.jessma.ext.spring.SpringBean;
import org.jessma.mvc.ActionSupport;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;

import java.util.Date;

public class BroadcastAction extends ActionSupport {

    private BroadcastService broadcastService = LocalServiceLocator.getService(BroadcastService.class);

    Logger logger = LogUtil.getLogger(BroadcastAction.class);

    //    @SpringBean("broadcastService")
    @Override
    public String execute() throws Exception {
        String copywritingId = getRequest().getParameter("copywritingId");
        broadcastService.publish(Integer.valueOf(copywritingId));
        getResponse().getWriter().write("copywritingId:" + copywritingId);
        return NONE;
    }
}
