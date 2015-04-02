package com.lesdo.standalone.service.impl;

import com.lesdo.standalone.annotation.LocalService;
import com.lesdo.standalone.service.CopywritingService;

import org.springframework.stereotype.Service;

/**
 * Created by jiangshan on 15/3/31.
 */
@LocalService(CopywritingService.class)
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
