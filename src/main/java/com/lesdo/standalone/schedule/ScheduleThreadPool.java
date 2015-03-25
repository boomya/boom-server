package com.lesdo.standalone.schedule;

import com.lesdo.standalone.global.NamedThreadFactory;

import java.util.concurrent.*;

/**
 * Created by jiangshan on 15/3/25.
 */
public class ScheduleThreadPool {

    private static final int CORE_THREAD_SIZE = 20;
    private final static ScheduledExecutorService scheduledExecutorServices = Executors.newScheduledThreadPool(CORE_THREAD_SIZE, new NamedThreadFactory("schedule"));
    public static ScheduledFuture<?> execute(Runnable command){
        return scheduledExecutorServices.scheduleWithFixedDelay(command, 0L, 1000L, TimeUnit.MILLISECONDS);
    }

}

