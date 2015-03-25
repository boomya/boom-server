package com.lesdo.standalone.global;

import java.util.concurrent.*;

/**
 * Created by jiangshan on 15/3/24.
 */
public class ExecutorServices {

    private static final int                     THREAD_SIZE = 16;
    private static final int                     QUEUE_SIZE  = 1024;

    public static ExecutorService createExecutorService(String threadName) {
        return new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 60L,
                                      TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(QUEUE_SIZE),
                                      new NamedThreadFactory(threadName)
        );
    }
}
