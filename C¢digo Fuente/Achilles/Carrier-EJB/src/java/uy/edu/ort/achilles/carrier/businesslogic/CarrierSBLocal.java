package uy.edu.ort.achilles.carrier.businesslogic;

import javax.ejb.Local;
import uy.edu.ort.achilles.carrier.exceptions.CarrierException;

@Local
public interface CarrierSBLocal {
    public void updateShippingStatus(Long carrierId, Long purchaseId, Long shippingId, String notes) throws CarrierException ;
}
