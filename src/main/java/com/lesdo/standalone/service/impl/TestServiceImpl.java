package com.lesdo.standalone.service.impl;

import com.lesdo.standalone.annotation.LocalService;
import com.lesdo.standalone.service.TestService;

/**
 * Created by jiangshan on 15/4/1.
 */
@LocalService(TestService.class)
public class TestServiceImpl extends AbstractService implements TestService {

    @Override
    public void say() {
        System.out.println("Hello world");
    }
}
