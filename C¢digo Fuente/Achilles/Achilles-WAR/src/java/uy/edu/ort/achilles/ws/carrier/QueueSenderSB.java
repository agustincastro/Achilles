package uy.edu.ort.achilles.ws.carrier;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
@LocalBean
public class QueueSenderSB {

    @Resource(lookup = "Factory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/AchillesQueue")
    private Queue queue;

    public void sendToQueue(Long carrierId, Long purchaseId, Long shippingId, String notes) {
        try {
            if (carrierId != null && purchaseId != null && shippingId != null) {
                String msge = carrierId + "#" + purchaseId + "#" + shippingId + "#"+ notes;
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer producer = session.createProducer(queue);
                TextMessage message = session.createTextMessage();
                message.setText(msge);
                producer.send(message);
                session.close();
                connection.close();
            }
        } catch (JMSException ex) {
            
        }

    }

}
