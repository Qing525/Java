package com.ljq.springbootactivemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : LJQ
 * @date : 2019/6/26 22:45
 */
public class Jms_Consumer_persist {
    private static final String ACTIVEMQ_URL = "tcp://94.191.56.73:61616";

    private static final String TOPIC_NAME = "topic_persist";

    public static void main(String[] args) throws JMSException {

        Connection connection = new ActiveMQConnectionFactory(ACTIVEMQ_URL).createConnection();

        connection.setClientID("李弟1");

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "Remark........");

        connection.start();
        Message message = subscriber.receive();

        while (null != message) {
            TextMessage message1 = (TextMessage) message;
            System.out.println("收到的持久化消息为：" + message1.getText());

            message = subscriber.receive();
        }

        session.close();
        connection.close();

    }
}
