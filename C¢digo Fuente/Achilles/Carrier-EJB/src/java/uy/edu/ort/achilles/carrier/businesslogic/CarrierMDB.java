package uy.edu.ort.achilles.carrier.businesslogic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/AchillesQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class CarrierMDB implements MessageListener {
    @EJB
    private CarrierSBLocal carriersb;
    
    
    public CarrierMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {      
            if (message != null) {
                System.out.println("mensaje leido con valores: ");
                TextMessage txt = (TextMessage)message;
                String contenido = txt.getText(); 
                String[] split = contenido.split("#");
                System.out.println("clientId: " + split[0]);
                System.out.println("purchaseId: " + split[1]);
                System.out.println("shippingId: " + split[2]);
                carriersb.updateShippingStatus(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2]), split[3]);                                               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
    }
}
