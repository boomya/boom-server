package com.lesdo.standalone.service;

/**
 * Created by jiangshan on 15/4/2.
 */
public interface BroadcastService {

    /**
     * 给全体用户发送通知
     * @param copywritingId
     */
    void publish(int copywritingId);
}
