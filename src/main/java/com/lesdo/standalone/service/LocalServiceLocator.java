package com.lesdo.standalone.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by jiangshan on 15/3/31.
 */
public class LocalServiceLocator implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static CopywritingService getCopywritingService(){
        return applicationContext.getBean(CopywritingService.class);
    }
}
