package com.ljq.mybatisplus.listener;

import com.alibaba.fastjson.JSON;
import com.ljq.mybatisplus.mapper.UserMapper;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : lijq
 * @date : 2020/4/7 13:12
 */
@RocketMQMessageListener(topic = "user-add-1", consumerGroup = "user-consumer-1")
@Component
public class UserListener1 implements RocketMQListener<MessageExt> {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void onMessage(MessageExt ext) {

        System.out.println(JSON.toJSONString(ext));
    }
}