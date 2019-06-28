import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author : LJQ
 * @date : 2019/6/26 19:36
 */
public class JmsConsumer {

   // public static final String ACTIVEMQ_URL = "tcp://94.191.56.73:61616";
    public static final String ACTIVEMQ_URL = "nio://94.191.56.73:61618";
    public static void main(String[] args) throws JMSException, IOException {


        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = factory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Queue queue = session.createQueue("QUEUE_NAME");

        MessageConsumer consumer = session.createConsumer(queue);

      /*
      /**     异步阻塞
      while (true) {

            TextMessage message = (TextMessage) consumer.receive(4000L);

            if (null != message) {
                System.out.println("***消费者收到消息：" + message.getText());
            } else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();*/
/**
 *  监听器  异步非阻塞
 */
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage) {

                    TextMessage message1 = (TextMessage) message;
                    try {
                        System.out.println("***消费者收到消息：" + message1.getText());
                        message.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();

    }
}