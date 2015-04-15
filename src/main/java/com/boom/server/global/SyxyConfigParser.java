package com.boom.server.global;

import org.dom4j.Element;
import org.jessma.app.UserConfigParser;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;

/**
 * Created by jiangshan on 15/3/12.
 * 用户自定义配置解析器
 */
public class SyxyConfigParser implements UserConfigParser {

    Logger logger = LogUtil.getLogger("sxy");

    private final static String SYXY_HOME = "syxy-home";

    @Override
    public void parse(Element user) {
        Element mh = user.element(SYXY_HOME);
        if (mh != null) {
            String syxyHome = mh.getTextTrim();
            logger.info("SYXY_HOME is: " + syxyHome);
        }
    }
}
