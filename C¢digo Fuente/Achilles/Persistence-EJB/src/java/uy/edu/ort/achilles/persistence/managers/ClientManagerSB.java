package uy.edu.ort.achilles.persistence.managers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.achilles.persistence.entities.Article;
import uy.edu.ort.achilles.persistence.entities.Client;
import uy.edu.ort.achilles.persistence.entities.History;
import uy.edu.ort.achilles.persistence.entities.Purchase;
import uy.edu.ort.achilles.persistence.entities.ShippingOption;
import uy.edu.ort.achilles.persistence.entities.ShippingStatus;
import uy.edu.ort.achilles.persistence.exceptions.PersistenceException;

@Stateless
public class ClientManagerSB implements ClientManagerSBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean availableArticle(Long articleId, Long shippindOptionId) {
        try {
            Article selected = em.find(Article.class, articleId);
            if (selected.getStock() > 0 && selected.isActive()) {
                for (ShippingOption option : selected.getShippingOptions()) {
                    if (option.getId() == shippindOptionId) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean validClient(Long clientId) {
        try {
            Client selected = em.find(Client.class, clientId);
            if (selected != null && selected.getType().equals("Client")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public void registerPurchase(Long articleId, Long clientId, Long shippingOptionId) throws PersistenceException {
        try {
            Article selectedArticle = em.find(Article.class, articleId);
            Client selectedClient = em.find(Client.class, clientId);
            ShippingOption selectedShipping = em.find(ShippingOption.class, shippingOptionId);
            selectedArticle.setStock(selectedArticle.getStock() - 1);
            Purchase purchase = new Purchase(selectedClient, selectedArticle, selectedShipping);
            em.persist(purchase);
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception");
            throw ex;
        }
    }

    @Override
    public List<Purchase> findOrders(Long clientId) throws PersistenceException {
        try {
            Client cli = em.find(Client.class, clientId);
            List<Purchase> purchases = cli.getPurchases();
            return purchases;
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when fetching orders");
            throw ex;
        }
    }

    @Override
    public List<History> findHistory(Long clientId, Long purchaseId) throws PersistenceException {
        try {
            Purchase purchase = em.find(Purchase.class, purchaseId);
            List<History> history = purchase.getHistorical();
            return history;
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when fetching history");
            throw ex;
        }
    }

    @Override
    public boolean hasPurchase(Long clientId, Long purchaseId) throws PersistenceException {
        try {
            Client client = em.find(Client.class, clientId);
            List<Purchase> purchases = client.getPurchases();
            for (Purchase p : purchases) {
                if (p.getId() == purchaseId) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database exception when validating purchases");
            throw ex;
        }
    }

    @Override
    public boolean isfinalState(Long purchaseId) throws PersistenceException {
        try {
            Purchase purchase = em.find(Purchase.class, purchaseId);
            ShippingStatus status = (ShippingStatus) em.createQuery(
                        "SELECT s FROM ShippingStatus s WHERE s.name = :Current").setParameter
        ("Current", purchase.getPurchaseState()).getSingleResult();
            return status.getNextStatus().isEmpty();    
        } catch (Exception e) {
            PersistenceException ex = new PersistenceException(e.getClass().getName(), "Database verifying if is final state");
            throw ex;
        }
    }
    
    @Override
    public void confirmPurchase(Long purchaseId){
        Purchase purchase = em.find(Purchase.class, purchaseId);
        purchase.setPurchaseState("Delivered");
    }
}
