package com.syxy.service.impl;

import com.syxy.service.UserService;
import org.jessma.util.LogUtil;

/**
 * Created by jiangshan on 15/3/20.
 */
public class UserServiceImpl implements UserService {
    private String test = null;
    public UserServiceImpl(String test){
        this.test = test;
    }

    @Override
    public void sayHello() {
        LogUtil.getJessMALogger().info("======= Hello World =======" + test);
    }
}
