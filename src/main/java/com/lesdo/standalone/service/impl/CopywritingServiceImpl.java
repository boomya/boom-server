package com.lesdo.standalone.service.impl;

import com.lesdo.standalone.service.CopywritingService;

import org.springframework.stereotype.Service;

/**
 * Created by jiangshan on 15/3/31.
 */
@Service("copywritingService")
public class CopywritingServiceImpl extends AbstractService implements CopywritingService {

    @Override
    public String getWelcomeCopy() {
        return "welcome...";
    }
}
