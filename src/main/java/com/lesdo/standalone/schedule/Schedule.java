package com.lesdo.standalone.schedule;

import org.jessma.util.LogUtil;
import org.slf4j.Logger;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by jiangshan on 15/3/25.
 */
public abstract class Schedule implements Runnable {
    protected Logger logger = LogUtil.getLogger("lesdo");
    private Task task = null;

    private long counter = 0L;
    private AtomicBoolean isDone = new AtomicBoolean(Boolean.TRUE);

    private ScheduledFuture<?> future = null;

    public void start(Task task){
        if(task == null){
            logger.error("task==null. start task fail. ");
            return;
        }
        this.task = task;
        future = ScheduleThreadPool.execute(this, task);
    }

    @Override
    public void run(){
        long beginTime = 0L;
        try{
            if(!isDone.get()){
                logger.info(" task(" + task.getTaskName() + ") not done. so return. " );
                return;
            }
            if(task.getEndTime()>0L && System.currentTimeMillis()>task.getEndTime()){
                logger.info(" task(" + task.getTaskName() + ") time's up. so cancel and return. " );
                future.cancel(true);
                return;
            }

            logger.info(" task(" + task.getTaskName() + ") starting..." );
            beginTime = System.currentTimeMillis();
            counter++;
            isDone.set(Boolean.FALSE);
            execute();

        } catch (Exception ex){
//            ex.printStackTrace();
            logger.error(ex.getMessage(), ex);
        } finally{
            logger.info(" task(" + task.getTaskName() + ") end. spend time:" + (System.currentTimeMillis()-beginTime) + " counter:" + counter);
            isDone.set(Boolean.TRUE);
        }

    }

    protected abstract void execute();
}
