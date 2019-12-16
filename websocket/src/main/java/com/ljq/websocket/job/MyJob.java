package com.ljq.websocket.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author : LJQ
 * @date : 2019/8/8 20:43
 */
@Configuration
public class MyJob {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        simpMessagingTemplate.convertAndSend("/server/byServer", System.currentTimeMillis());
    }
}
