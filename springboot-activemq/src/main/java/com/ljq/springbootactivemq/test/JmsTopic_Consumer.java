package com.ljq.springbootactivemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author : LJQ
 * @date : 2019/6/26 21:13
 */
public class JmsTopic_Consumer {
    private static final String ACTIVEMQ_URL = "tcp://94.191.56.73:61616";
    private static final String TOPIC_NAME = "topic";

    public static void main(String[] args) throws JMSException, IOException {


        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = factory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener((message -> {

            if (null != message && message instanceof TextMessage) {

                TextMessage message1 = (TextMessage) message;
                try {
                    System.out.println("***Topic3消费者收到消息：" + message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }));


        System.in.read();
        consumer.close();
        session.close();
        connection.close();

    }
}
