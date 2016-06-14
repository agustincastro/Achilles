package uy.edu.ort.achilles.persistence.managers;

import javax.ejb.Local;
import uy.edu.ort.achilles.persistence.entities.Purchase;
import java.util.List;
import uy.edu.ort.achilles.persistence.entities.History;
import uy.edu.ort.achilles.persistence.exceptions.PersistenceException;

@Local
public interface ClientManagerSBLocal {
    
    //Verifies if selected article exists, is in stcock, available 
    //for purchase, and has selected shipping option
    public boolean availableArticle(Long articleId, Long shippindOptionId);
    
    //verifies if a client is registered
    public boolean validClient(Long clientId);
    
    //registers a purchase in the system
    public void registerPurchase(Long articleId, Long clientId, Long shippingOptionId) throws PersistenceException;
    
    //returns all purchases of a specified client
    public List<Purchase> findOrders(Long clientId) throws PersistenceException;
    
    public List<History> findHistory(Long clientId, Long purchaseId) throws PersistenceException;
    public boolean hasPurchase(Long clientId, Long purchaseId) throws PersistenceException;
    
    public void confirmPurchase(Long purchaseId);

    public boolean isfinalState(Long purchaseId) throws PersistenceException;
}
