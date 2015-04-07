package com.lesdo.standalone.service.impl;

import com.lesdo.ext.spring.annotation.LocalService;
import com.lesdo.ext.spring.annotation.LocalServiceField;
import com.lesdo.im.IMUtils;
import com.lesdo.standalone.service.BroadcastService;
import com.lesdo.standalone.service.CopywritingService;
import com.lesdo.standalone.service.TestService;
import com.lesdo.standalone.util.LesdoLogUtil;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;

/**
 * Created by jiangshan on 15/3/31.
 */
@LocalService
public class BroadcastServiceImpl extends AbstractService implements BroadcastService {

    private Logger logger = LesdoLogUtil.getLogger();
    @LocalServiceField
    CopywritingService copywritingService;
    @LocalServiceField
    TestService testService;

    @Override
    public void init() {
        logger.info("======== BroadcastServiceImpl ========");
    }

    @Override
    public void publish(int copywritingId) {

        String msg = copywritingService.getCopywritingById(copywritingId);
        IMUtils.sendMsgToAll(msg);
    }
}
