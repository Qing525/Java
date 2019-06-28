package com.ljq.springbootactivemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @author : LJQ
 * @date : 2019/6/26 23:58
 */
@Component
public class Produce {
       @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
     @Autowired
    Queue queue;

     public void produceMsg(){

         jmsMessagingTemplate.convertAndSend(queue,"**********"+ UUID.randomUUID().toString().substring(0,6));
     }

    /**
     * 间隔定投
     */
     @Scheduled(fixedDelay = 3000)
     public void produceSc(){

         jmsMessagingTemplate.convertAndSend(queue,"**********"+ UUID.randomUUID().toString().substring(0,6));

         System.out.println("**********"+ UUID.randomUUID().toString().substring(0,6));
     }

}
