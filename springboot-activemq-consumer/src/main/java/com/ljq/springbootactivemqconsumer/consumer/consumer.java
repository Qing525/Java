package com.ljq.springbootactivemqconsumer.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author : LJQ
 * @date : 2019/6/27 0:14
 */
@Component
public class consumer {

@JmsListener(destination = "${myqueue}")
public void receive(TextMessage textMessage) throws JMSException {

    System.out.println(textMessage.getText());
}

}
