package com.boom.server.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLogger;

/**
 * Created by jiangshan on 15/4/7.
 */
public class LesdoLogUtil {
    /** 日志对象名称 */
    private static final String LESDO_LOGGER_NAME	= "Lesdo";
    /** 日志对象 */
    private static final Logger lesdoLogger;

    static
    {
        lesdoLogger = LoggerFactory.getLogger(LESDO_LOGGER_NAME);

        if(lesdoLogger == NOPLogger.NOP_LOGGER)
            System.err.println("!!! --> Lesdo Logger is not valid, please check <-- !!!");
    }
    public static Logger getLogger(){
        return lesdoLogger;
    }
}
