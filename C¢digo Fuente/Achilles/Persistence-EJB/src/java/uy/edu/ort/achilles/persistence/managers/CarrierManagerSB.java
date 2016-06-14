package uy.edu.ort.achilles.persistence.managers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.achilles.persistence.entities.Client;
import uy.edu.ort.achilles.persistence.entities.History;
import uy.edu.ort.achilles.persistence.entities.Purchase;
import uy.edu.ort.achilles.persistence.entities.ShippingStatus;
import uy.edu.ort.achilles.persistence.exceptions.PersistenceException;

@Stateless
public class CarrierManagerSB implements CarrierManagerSBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void updateShippingStatus(Long carrierId, Long purchaseId, Long shippingStatusId, String place, String notes) throws PersistenceException {
        try {
            Client carrier = em.find(Client.class, carrierId);
            String carrierEnterprise = carrier.getEnterprise();
            String carrierName = carrier.getName();
            Purchase purchase = em.find(Purchase.class, purchaseId);
            ShippingStatus status = em.find(ShippingStatus.class, shippingStatusId);

            History history = new History(purchase, status, carrierName, place, notes, carrierEnterprise);
            purchase.getHistorical().add(history);
            purchase.setPurchaseState(status.getName());
            em.persist(history);
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when fetching history");
            throw ex;
        }
    }

    @Override
    public boolean belongsToEnterprise(Long carrierId, Long purchaseId) throws PersistenceException {
        try {
            Client carrier = em.find(Client.class, carrierId);
            String carrierEnterprise = carrier.getEnterprise();
            Purchase purchase = em.find(Purchase.class, purchaseId);
            if (purchase.getHistorical().isEmpty()) {
                return true;
            } else {
                String currentEnterprise = purchase.getHistorical().get(0).getEnterprise();
                return carrierEnterprise.equals(currentEnterprise);
            }
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when checking enterprise");
            throw ex;
        }
    }

    @Override
    public boolean validCarrier(Long carrierId) {
        try {
            Client selected = em.find(Client.class, carrierId);
            if (selected != null && selected.getType().equals("Carrier")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean validStatusChange(Long purchaseId, Long shippingStatusId) throws PersistenceException {
        Purchase purchase = em.find(Purchase.class, purchaseId);
        String currentStatus = purchase.getPurchaseState();
        ShippingStatus newStatus = em.find(ShippingStatus.class, shippingStatusId);
        if (currentStatus == null) {
            return true;
        } else {
            try {
                ShippingStatus status = (ShippingStatus) em.createQuery(
                        "SELECT s FROM ShippingStatus s WHERE s.name = :Current").setParameter
        ("Current", currentStatus).getSingleResult();
                for (String cs : status.getNextStatus()) {
                    if (cs.equals(newStatus.getName())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when validating status");
                throw ex;
            }
            return false;
        }
    }

    @Override
    public boolean validUserChanging(Long carrierId, Long purchaseId) throws PersistenceException {
        Client user = em.find(Client.class, carrierId);
        Purchase purchase = em.find(Purchase.class, purchaseId);
        String currentStatus = purchase.getPurchaseState();
        if (currentStatus == null) {
            return true;
        } else {
            try {
                ShippingStatus status = (ShippingStatus) em.createQuery(
                        "SELECT s FROM ShippingStatus s WHERE s.name = :Current").setParameter
        ("Current", currentStatus).getSingleResult();
                return (user.getType().equals("Client") && status.isAuthorizedClient())
                        || (user.getType().equals("Carrier") && status.isAuthorizedCarrier());
            } catch (Exception e) {
                PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when validating user");
                throw ex;
            }
        }
    }

}
