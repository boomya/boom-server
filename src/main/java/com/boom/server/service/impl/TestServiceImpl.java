package com.boom.server.service.impl;

import com.boom.ext.spring.annotation.LocalService;
import com.boom.server.service.TestService;

/**
 * Created by jiangshan on 15/4/1.
 */
@LocalService
public class TestServiceImpl extends AbstractService implements TestService {

    @Override
    public void say() {
        System.out.println("Hello world");
    }
}
