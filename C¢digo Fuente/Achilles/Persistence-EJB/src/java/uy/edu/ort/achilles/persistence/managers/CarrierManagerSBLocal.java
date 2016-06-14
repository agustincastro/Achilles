package uy.edu.ort.achilles.persistence.managers;

import javax.ejb.Local;
import uy.edu.ort.achilles.persistence.exceptions.PersistenceException;


@Local
public interface CarrierManagerSBLocal {
    public void updateShippingStatus(Long carrierId, Long purchaseId, Long shippingStatusId,String place, String notes) throws PersistenceException;
    
    public boolean belongsToEnterprise(Long carrierId, Long purchaseId) throws PersistenceException;
    public boolean validCarrier(Long carrierId);
    public boolean validStatusChange(Long purchaseId, Long shippingStatusId) throws PersistenceException;
    public boolean validUserChanging(Long carrierId, Long purchaseId) throws PersistenceException;
   
}
