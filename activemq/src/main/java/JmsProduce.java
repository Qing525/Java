import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

/**
 * @author : LJQ
 * @date : 2019/6/26 19:19
 */
public class JmsProduce {
  //  public static final String ACTIVEMQ_URL = "tcp://94.191.56.73:61616";
  public static final String ACTIVEMQ_URL = "nio://94.191.56.73:61618";
    public static void main(String[] args) throws JMSException {


        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
factory.setUseAsyncSend(true);
        Connection connection = factory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("QUEUE_NAME");
/*
        MessageProducer producer = session.createProducer(queue);

        producer.setDeliveryMode(DeliveryMode.PERSISTENT);*/
        ActiveMQMessageProducer  producer = (ActiveMQMessageProducer) session.createProducer(queue);


        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("msg" + i);
            textMessage.setJMSMessageID(UUID.randomUUID().toString()+"**********JQ");
            String msgId=textMessage.getJMSMessageID();
//            producer.send(textMessage);

  producer.send(textMessage, new AsyncCallback() {
      @Override
      public void onSuccess() {

          System.out.println(msgId+"has been ok");
      }

      @Override
      public void onException(JMSException e) {

          System.out.println(msgId+"has been failed");
      }
  });

        }

        producer.close();
        session.close();
        connection.close();


        System.out.println("消息发布成功");



    }

}
