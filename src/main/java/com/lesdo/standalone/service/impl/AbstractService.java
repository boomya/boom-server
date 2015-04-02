package com.lesdo.standalone.service.impl;

import com.lesdo.standalone.service.CopywritingService;
import com.lesdo.standalone.service.LocalServiceLocator;

import java.util.logging.Logger;

/**
 * Created by jiangshan on 15/3/25.
 */
public abstract class AbstractService {

    public void init(){
        Logger.getLogger("AbstractService").info("======================AbstractService====================");
    }

    protected <T> T getService(Class<T> clazz, T t){
        if(t == null){
            return LocalServiceLocator.getService(clazz);
        }
        return t;
    }
}
