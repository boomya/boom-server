package com.boom.server.schedule;

/**
 * Created by jiangshan on 15/3/25.
 */
public class TestScheduleTask extends Schedule {

    @Override
    protected void execute() {
        logger.info("-------- TestScheduleTask --------");
    }
}
