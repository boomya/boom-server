package com.boom.server.service.impl;

import com.boom.ext.spring.thread.Task;
import com.boom.server.schedule.AutoWelcomeTask;
import com.boom.server.schedule.Schedule;
import com.boom.server.service.ScheduleService;
import org.jessma.util.LogUtil;

/**
 * Created by jiangshan on 15/3/25.
 */
public class ScheduleServiceImpl extends AbstractService implements ScheduleService {

    @Override
    public void start() {
    }

    public void init() {
        LogUtil.getJessMALogger().info("------ScheduleServiceImpl init----------");
//        Schedule schedule = new TestScheduleTask();
//        Task task = new Task();
//        task.setTaskName(" test-task ");
//        schedule.start(task);
//        ScheduleThreadPool.execute(new TestScheduleTask());

        Schedule schedule = new AutoWelcomeTask();
        Task task = new Task();
        task.setTaskName("AutoWelcomeTask");
        task.setIntervalTime(2000L);
        schedule.start(task);
    }
}
