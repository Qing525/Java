package com.ljq.mybatisplus.listener;

import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author : lijq
 * @date : 2020/4/10 9:18
 */
@Component
//@RocketMQMessageListener()
public class UserListener2 implements RocketMQLocalTransactionListener {
    //执行本地事务
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        return null;
    }

    //消息回查
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return null;
    }
}
