package uy.edu.ort.achilles.client.businesslogic;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.achilles.client.dto.HistoryDTO;
import uy.edu.ort.achilles.client.dto.PurchaseDTO;
import uy.edu.ort.achilles.client.exceptions.ClientException;



@Local
public interface ClientSBLocal {
    
   public void purchaseArticle(Long articleId, Long clientId, Long shippingId) throws ClientException;
   
   public List<PurchaseDTO> showOrders(Long clientId) throws ClientException;
   
 //  public List<ShippingStatus> showStatusHistory(int purchaseId); 
   
   public float currencyConversion(float amount, String currencyFrom, String currencyTo) throws ClientException;
   
   public List<HistoryDTO> getHistory(Long clientId, Long purchaseId);
   
   public void confirmArrival(Long clientId, Long purchaseId) throws ClientException;
}
