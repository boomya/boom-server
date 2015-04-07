package com.lesdo.standalone.service.impl;

import java.util.logging.Logger;

/**
 * Created by jiangshan on 15/3/25.
 */
public abstract class AbstractService {

    public void init() {
        Logger.getLogger("AbstractService").info("======================AbstractService====================");
    }
}
