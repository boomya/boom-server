package com.lesdo.standalone.global;

import org.jessma.util.LogUtil;
import org.slf4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by jiangshan on 15/3/20.
 */
public class SyxyContextLoaderListener extends ContextLoaderListener {

    private Logger logger = LogUtil.getLogger("sxy");

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        logger.info("===== SyxyContextLoaderListener contextInitialized ======");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        logger.info("===== SyxyContextLoaderListener contextDestroyed ======");
    }
}
