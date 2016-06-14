package uy.edu.ort.achilles.carrier.businesslogic;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import uy.edu.ort.achilles.carrier.exceptions.CarrierException;
import uy.edu.ort.achilles.logger.LoggerSBLocal;
import uy.edu.ort.achilles.persistence.managers.CarrierManagerSBLocal;

@Stateless
public class CarrierSB implements CarrierSBLocal {

    @EJB
    private CarrierManagerSBLocal carriermanager;
    @EJB
    private LoggerSBLocal logger;

    @Override
    public void updateShippingStatus(Long carrierId, Long purchaseId, Long shippingId, String notes) throws CarrierException {
        try {
            if (carriermanager.belongsToEnterprise(carrierId, purchaseId)) {
                if (carriermanager.validCarrier(carrierId)) {
                    if (carriermanager.validStatusChange(purchaseId, shippingId)) {
                        if (carriermanager.validUserChanging(carrierId, purchaseId)) {
                            carriermanager.updateShippingStatus(carrierId, purchaseId, shippingId, notes, notes);
                            logger.getLogger().info("Shipping status succesfully updated for purchase: " + purchaseId + " by: " + carrierId);
                        } else {
                            CarrierException ex = new CarrierException(this.getClass().getName(), "Current user can't change the status");
                            logger.getLogger().error("Error while updating shipping status");
                            throw ex;
                        }
                    } else {
                        CarrierException ex = new CarrierException(this.getClass().getName(), "Selected status is not a valid option to change");
                        logger.getLogger().error("Error while updating shipping status");
                        throw ex;
                    }
                } else {
                    CarrierException ex = new CarrierException(this.getClass().getName(), "Current carrier can't change the status");
                    logger.getLogger().error("Error while updating shipping status");
                    throw ex;
                }
            } else {
                CarrierException ex = new CarrierException(this.getClass().getName(), "Enterprise corresponding this shipping don't match with current");
                logger.getLogger().error("Error while updating shipping status");
                throw ex;
            }
        } catch (Exception ex) {
            CarrierException e = new CarrierException(ex.getClass().getName(), ex.toString());
            logger.getLogger().error("Error while updating shipping status");
            throw e;
        }
    }

}
