package com.lesdo.standalone.service.impl;

import com.lesdo.standalone.annotation.LocalService;
import com.lesdo.standalone.service.UserService;
import org.jessma.util.LogUtil;

/**
 * Created by jiangshan on 15/3/20.
 */
@LocalService(UserService.class)
public class UserServiceImpl extends AbstractService implements UserService {
    private String test = null;
//    public UserServiceImpl(String test){
//        this.test = test;
//    }

//    public void init(){
//        LogUtil.getJessMALogger().info("======= INIT =======");
//    }

    @Override
    public void sayHello() {
        LogUtil.getJessMALogger().info("======= Hello World =======" + test);
    }
}
