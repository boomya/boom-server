package com.lesdo.standalone.service.impl;

import com.lesdo.ext.spring.annotation.LocalService;
import com.lesdo.standalone.service.CopywritingService;

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
