package com.lesdo.standalone.service.impl;

import com.lesdo.im.IMUtils;
import com.lesdo.standalone.annotation.LocalService;
import com.lesdo.standalone.service.BroadcastService;
import com.lesdo.standalone.service.CopywritingService;
import com.lesdo.standalone.service.LocalServiceLocator;

/**
 * Created by jiangshan on 15/3/31.
 */
@LocalService(BroadcastService.class)
public class BroadcastServiceImpl extends AbstractService implements BroadcastService {

    @Override
    public void publish(int copywritingId) {
        CopywritingService copywritingService = LocalServiceLocator.getService(CopywritingService.class);
        String msg = copywritingService.getCopywritingById(copywritingId);
        IMUtils.sendMsgToAll(msg);
    }
}
