package com.ljq.springbootactivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author : LJQ
 * @date : 2019/6/26 23:56
 */
@Component
@EnableJms
public class configBean {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue() {

        return new ActiveMQQueue(myQueue);
    }
}
