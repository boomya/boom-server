package com.lesdo.standalone.schedule;

import com.lesdo.im.IMUtils;
import com.lesdo.standalone.redis.RedisPool;
import com.lesdo.standalone.service.CopywritingService;
import com.lesdo.standalone.service.LocalServiceLocator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiangshan on 15/3/25.
 * 新用户注册成功后小Do自动发送欢迎消息
 */
public class AutoWelcomeTask extends Schedule {

    private        AtomicInteger      counter            = new AtomicInteger(0);
    private static CopywritingService copywritingService = LocalServiceLocator.getCopywritingService();

    @Override
    protected void execute() {
        logger.info("-------- AutoWelcomeTask --------");
        /**
         * 获取redis中刚加入的用户id列表并清空
         * 使用小Do帐号发送欢迎信息
         */
//        List<Long> userIds = new ArrayList<Long>(1);
//        userIds.add(32932L);
        List<Long> userIdList = RedisPool.getLatestUserRegist();
        if (userIdList != null && userIdList.size() > 0) {
            IMUtils.sendMsg(userIdList, copywritingService.getWelcomeCopy() + counter.incrementAndGet());
        }

    }
}
