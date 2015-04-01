package com.lesdo.standalone.redis;

import com.lesdo.standalone.global.SystemGlobals;
import org.jessma.util.LogUtil;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RedisPool {

    private static final Logger log = LogUtil.getLogger(RedisPool.class);

    /**
     * 连接池
     */
    private static JedisPool jedisPool;
    // private static RedisManager redisManager;

    private static String ip   = SystemGlobals.get("redis.ip");
    private static int    port = SystemGlobals.getInt("redis.port");

    static {
        log.info("lesdo-standalone 初始化redis");
        init();
    }

    private static Jedis getResource() {
        return jedisPool.getResource();
    }

    /**
     * 构造函数
     *
     * @return
     */
    public static void init() {
        initialPool();
    }

    private static void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(800);// 最大连接数
        config.setMaxIdle(600);// 最大空闲数
        config.setMaxWaitMillis(30 * 60 * 1000);// 超时时间
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool(config, ip, port, 60 * 1000);
    }

    /**
     * 获取最近新增用户列表
     */
    public static List<Long> getLatestUserRegist() {
        Jedis jedis = getResource();
        try {
            Pipeline pipeline = jedis.pipelined();
            //获取当前整个列表
            pipeline.lrange(RedisKey.LATEST_USER_REGIST, 0, -1);
            //清空当前整个列表
            pipeline.ltrim(RedisKey.LATEST_USER_REGIST, 1, 0);
            List<Object> results = pipeline.syncAndReturnAll();
            if (results != null && results.size() > 0) {
                return toLong((List<String>)results.get(0));
            }

        } catch (Exception e) {
            log.error("saveRedisDynamic error ," + e.getMessage(), e);
            jedisPool.returnBrokenResource(jedis);
        } finally {
            if (jedis != null) {
                returnResource(jedis);
            }

        }
        return Collections.EMPTY_LIST;
    }

    private static List<Long> toLong(List<String> list){
        if(list!=null && list.size()>0){
            List<Long> targetList = new ArrayList<Long>(list.size());
            try{
                for(String tmp:list){
                    targetList.add(Long.valueOf(tmp));
                }
                return targetList;
            } catch (Exception ex){
                log.error(ex.getMessage(), ex);
            }
        }

        return Collections.EMPTY_LIST;
    }

    private static void returnResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        } catch (Exception e) {
            log.warn("redis 返回池出错：" + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        List<Long> userIdList = getLatestUserRegist();
        for (Long userId : userIdList) {
            System.out.println(userId);
        }
    }
}
