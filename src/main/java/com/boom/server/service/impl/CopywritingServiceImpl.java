package com.boom.server.service.impl;

import com.boom.ext.spring.annotation.LocalService;
import com.boom.server.service.CopywritingService;

/**
 * Created by jiangshan on 15/3/31.
 */
@LocalService
public class CopywritingServiceImpl extends AbstractService implements CopywritingService {

    @Override
    public String getWelcomeCopy() {
        return "welcome...";
    }

    @Override
    public String getCopywritingById(int copywritingId) {
        return "copywriting:" + copywritingId;
    }
}
