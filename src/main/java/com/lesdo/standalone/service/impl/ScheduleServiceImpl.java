package com.lesdo.standalone.service.impl;

import com.lesdo.standalone.schedule.Schedule;
import com.lesdo.standalone.schedule.ScheduleThreadPool;
import com.lesdo.standalone.schedule.Task;
import com.lesdo.standalone.schedule.TestScheduleTask;
import com.lesdo.standalone.service.ScheduleService;
import org.jessma.util.LogUtil;

/**
 * Created by jiangshan on 15/3/25.
 */
public class ScheduleServiceImpl extends Service implements ScheduleService {

    @Override
    public void start() {
    }

    @Override
    public void init() {
        LogUtil.getJessMALogger().info("------ScheduleServiceImpl init----------");
        Schedule schedule = new TestScheduleTask();
        Task task = new Task();
        task.setTaskName(" test-task ");
        schedule.start(task);
//        ScheduleThreadPool.execute(new TestScheduleTask());
    }
}
