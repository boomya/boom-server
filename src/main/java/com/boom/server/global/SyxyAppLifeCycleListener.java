package com.boom.server.global;

import org.jessma.app.AppLifeCycleListener;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * Created by jiangshan on 15/3/12.
 */
public class SyxyAppLifeCycleListener implements AppLifeCycleListener {

    Logger logger = LogUtil.getLogger("sxy");

    @Override
    public void onStartup(ServletContext servletContext, ServletContextEvent servletContextEvent) {
        LogUtil.getLogger(SyxyAppLifeCycleListener.class).info("==================111111111111");
        logger.info(this.getClass().getName() + " -> onStartup()");

    }

    @Override
    public void onShutdown(ServletContext servletContext, ServletContextEvent servletContextEvent) {
        logger.info(this.getClass().getName() + " -> onShutdown()");
    }
}
