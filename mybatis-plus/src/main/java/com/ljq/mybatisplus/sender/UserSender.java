package com.ljq.mybatisplus.sender;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author : lijq
 * @date : 2020/4/7 12:44
 */

@Component
public class UserSender {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void userAdd(String s) {
        rocketMQTemplate.convertAndSend("user-add", s);
    }
    public void userAdd1(MessageExt ext) {
        rocketMQTemplate.convertAndSend("user-add-1", ext);
    }
    public void userAdd2(MessageExt ext) {
        rocketMQTemplate.sendMessageInTransaction("user-transaction", MessageBuilder.withPayload("x")
                        .setHeader("txId",UUID.randomUUID().toString().replaceAll("-","")).build(),
                ext);

    }
}
