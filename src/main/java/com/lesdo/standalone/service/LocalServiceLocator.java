package com.lesdo.standalone.service;

import com.lesdo.standalone.annotation.LocalService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangshan on 15/3/31.
 */
public class LocalServiceLocator<T> implements ApplicationContextAware {
    private static Map<String, Object> serverMap = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        serverMap = new HashMap<String, Object>();
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(LocalService.class);
        for (Object serviceBean : serviceBeanMap.values()) {
//            String serviceName = serviceBean.getClass().getAnnotation(LocalService.class).name();

            serverMap.put(serviceBean.getClass().getAnnotation(LocalService.class).value().getSimpleName(), serviceBean);
        }
    }

    public static <T> T getService(Class<T> clazz){
        return (T)serverMap.get(clazz.getSimpleName());
    }
}
