package com.lesdo.standalone.service.impl;

import com.lesdo.ext.spring.thread.Task;
import com.lesdo.standalone.schedule.AutoWelcomeTask;
import com.lesdo.standalone.schedule.Schedule;
import com.lesdo.standalone.service.ScheduleService;
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
