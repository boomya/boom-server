package com.boom.server.service.impl;

import com.boom.ext.spring.annotation.LocalService;
import com.boom.ext.spring.annotation.LocalServiceField;
import com.boom.server.service.BroadcastService;
import com.boom.server.service.CopywritingService;
import com.boom.server.service.TestService;
import com.boom.server.util.LesdoLogUtil;
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
    TestService        testService;

    @Override
    public void init() {
        logger.info("======== BroadcastServiceImpl ========");
    }

    @Override
    public void publish(int copywritingId) {

    }
}
