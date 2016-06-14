package uy.edu.ort.achilles.client.businesslogic;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import uy.edu.ort.achilles.client.dto.HistoryDTO;
import uy.edu.ort.achilles.client.dto.PurchaseDTO;
import uy.edu.ort.achilles.client.exceptions.ClientException;
import uy.edu.ort.achilles.converter.CurrencyConverterSBLocal;
import uy.edu.ort.achilles.logger.LoggerSBLocal;
import uy.edu.ort.achilles.persistence.entities.History;
import uy.edu.ort.achilles.persistence.entities.Purchase;
import uy.edu.ort.achilles.persistence.managers.ClientManagerSBLocal;
import uy.edu.ort.achilles.persistence.exceptions.PersistenceException;

@Stateless
public class ClientSB implements ClientSBLocal {

    @EJB
    private ClientManagerSBLocal clientManagerSB;
    @EJB
    private CurrencyConverterSBLocal currencyConverter;
    @EJB
    private LoggerSBLocal logger;

    @Override
    public void purchaseArticle(Long articleId, Long clientId, Long shippingId) throws ClientException {

        try {
            if (clientManagerSB.availableArticle(articleId, shippingId)) {
                if (clientManagerSB.validClient(clientId)) {
                    clientManagerSB.registerPurchase(articleId, clientId, shippingId);
                    logger.getLogger().info("New purchase, aticle: " + articleId + " client: " + clientId);
                } else {
                    ClientException e = new ClientException(this.getClass().getName(), "The client was not found");
                    logger.getLogger().error("Error registered while processing the purchase");
                    throw e;
                }
            } else {
                ClientException e = new ClientException(this.getClass().getName(), "The article is not available");
                logger.getLogger().error("Error registered while processing the purchase");
                throw e;
            }
        } catch (Exception ex) {
            ClientException e = new ClientException(ex.getClass().getName(), ex.toString());
            logger.getLogger().error("Error registered while processing the purchase");
            throw e;
        }
    }

    @Override
    public List<PurchaseDTO> showOrders(Long clientId) throws ClientException {
        List<Purchase> orders = new ArrayList<Purchase>();
        List<PurchaseDTO> ret = new ArrayList<PurchaseDTO>();
        try {
            if (clientManagerSB.validClient(clientId)) {
                orders = clientManagerSB.findOrders(clientId);
                for (Purchase p : orders) {
                    PurchaseDTO dto = new PurchaseDTO();
                    dto.setArticle(p.getArticle().getName());
                    dto.setPurchaseDate(p.getDate());
                    dto.setPurchaseState(p.getPurchaseState());
                    dto.setEstimatedTimeLeft("Between " + p.getShippingOption().getMinimumTime()
                            + " and " + p.getShippingOption().getMaximumTime() + " days");
                    ret.add(dto);
                }
                logger.getLogger().info("Purchases where displayed by client: " + clientId);
                return ret;
            } else {
                ClientException e = new ClientException(this.getClass().getName(), "The client was not found");
                logger.getLogger().error("Error while displaying purchases of client: " + clientId);
                throw e;
            }
        } catch (Exception ex) {
            ClientException e = new ClientException(ex.getClass().getName(), ex.toString());
            logger.getLogger().error("Error while displaying purchases of client: " + clientId);
            throw e;
        }
    }

    @Override
    public float currencyConversion(float amount, String currencyFrom, String currencyTo) throws ClientException {
        try {
            if (!"".equals(currencyFrom) || !"".equals(currencyTo) || currencyFrom == null || currencyTo == null) {
                float coef = currencyConverter.convert(currencyFrom, currencyTo);
                logger.getLogger().info("Currency converion processed succesfully");
                return amount * coef;
            }
        } catch (Exception x) {
            ClientException ex = new ClientException(x.getClass().toString(), x.getMessage());
            logger.getLogger().error("Error while making conversion");
            throw ex;
        }
        return 0;
    }

    @Override
    public List<HistoryDTO> getHistory(Long clientId, Long purchaseId) {
        List<History> history = null;
        List<HistoryDTO> orderHistory = new ArrayList<HistoryDTO>();
        try {
            if (clientManagerSB.hasPurchase(clientId, purchaseId)) {
                history = clientManagerSB.findHistory(clientId, purchaseId);
                for (History h : history) {
                    HistoryDTO dto = new HistoryDTO();
                    dto.setDate(h.getDate());
                    dto.setEnterprice(h.getEnterprise());
                    dto.setNotes(h.getNote());
                    dto.setPlace(h.getPlace());
                    orderHistory.add(dto);
                }
            }
        } catch (PersistenceException ex) {
            logger.getLogger().error("Error while fetching history for purchase: " + purchaseId + " requested by client: " + clientId);
        }
        logger.getLogger().info("History for purchase: " + purchaseId + " requested by client: " + clientId);
        return orderHistory;
    }

    @Override
    public void confirmArrival(Long clientId, Long purchaseId) throws ClientException {
        try {
            if (clientManagerSB.validClient(clientId)) {
                if (clientManagerSB.hasPurchase(clientId, purchaseId)) {
                    if (clientManagerSB.isfinalState(purchaseId)) {
                        clientManagerSB.confirmPurchase(purchaseId);
                        logger.getLogger().info("Purchase arrival confirmed succesfully");
                    } else {
                        ClientException e = new ClientException(this.getClass().getName(), "Shipping state is not final");
                        logger.getLogger().error("Error ocurred when confirming purchase " + purchaseId);
                        throw e;
                    }
                } else {
                    ClientException e = new ClientException(this.getClass().getName(), "The client doesn't have selected purchase");
                    logger.getLogger().error("Error ocurred when confirming purchase " + purchaseId);
                    throw e;
                }
            } else {
                ClientException e = new ClientException(this.getClass().getName(), "The client is not valid");
                logger.getLogger().error("Error ocurred when confirming purchase " + purchaseId);
                throw e;
            }
        } catch (Exception x) {
            ClientException ex = new ClientException(x.getClass().toString(), x.getMessage());
            logger.getLogger().error("Error ocurred when confirming purchase " + purchaseId);
            throw ex;
        }
    }

}
