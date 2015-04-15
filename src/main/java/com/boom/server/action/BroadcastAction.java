package com.boom.server.action;

import com.boom.ext.spring.annotation.LocalServiceField;
import com.boom.server.service.BroadcastService;
import org.jessma.mvc.ActionSupport;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;

public class BroadcastAction extends ActionSupport {
    @LocalServiceField
    private BroadcastService broadcastService;

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
