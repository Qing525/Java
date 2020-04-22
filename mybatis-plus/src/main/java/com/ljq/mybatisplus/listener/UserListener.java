package com.ljq.mybatisplus.listener;

import com.alibaba.fastjson.JSON;
import com.ljq.mybatisplus.entity.User;
import com.ljq.mybatisplus.mapper.UserMapper;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : lijq
 * @date : 2020/4/7 12:42
 */
@RocketMQMessageListener(topic = "user-add", consumerGroup = "user-consumer")
@Component
public class UserListener implements RocketMQListener<String> {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void onMessage(String s) {
        User user = JSON.parseObject(s, User.class);
        userMapper.insert(user);
    }
}
