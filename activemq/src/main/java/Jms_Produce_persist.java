import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : LJQ
 * @date : 2019/6/26 22:40
 */
public class Jms_Produce_persist {

    private static final String ACTIVEMQ_URL = "tcp://94.191.56.73:61616";

    private static final String TOPIC_NAME = "topic_persist";

    public static void main(String[] args) throws JMSException {


        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = factory.createConnection();



        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageProducer producer = session.createProducer(topic);

        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        connection.start();

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("topic_persist_Msg" + i);
            producer.send(textMessage);
        }

        producer.close();
        session.close();
        connection.close();


        System.out.println("topic消息发布成功");
    }

}
