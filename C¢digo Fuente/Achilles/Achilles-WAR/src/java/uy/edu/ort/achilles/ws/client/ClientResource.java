package uy.edu.ort.achilles.ws.client;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import uy.edu.ort.achilles.ws.carrier.QueueSenderSB;
import uy.edu.ort.achilles.client.businesslogic.ClientSBLocal;
import uy.edu.ort.achilles.client.dto.HistoryDTO;
import uy.edu.ort.achilles.client.dto.PurchaseDTO;

@Path("/client")
@Stateless
public class ClientResource {

    @EJB
    private ClientSBLocal clientSBLocal;
    @EJB
    private QueueSenderSB queuesender;

    public ClientResource() {
    }

    @PUT
    @Path("/addPurchase")
    @Produces("application/json")
    public Response addPurchase(
            @QueryParam(value = "articleId") Long articleId,
            @QueryParam(value = "clientId") Long clientId,
            @QueryParam(value = "shippingId") Long shippingId) {
        Response response;
        try {
            clientSBLocal.purchaseArticle(articleId, clientId, shippingId);
            response = Response.ok().build();
        } catch (Exception e) {
            response = Response.serverError().entity(e).build();
        }
        return response;
    }
    
    @GET
    @Path("/currencyConverter")
    @Produces("application/json")
    public String convertCurrency(@QueryParam(value = "amount") float amount,
                                @QueryParam(value = "currencyFrom") String currencyFrom,
                                @QueryParam(value = "currencyTo") String currencyTo){
        float conversion = 0;
        try{
            conversion = clientSBLocal.currencyConversion(amount, currencyFrom, currencyTo);
        }catch(Exception e){
           
        }
        return conversion + "";
    }
    
    @GET
    @Path("/getHistorical")
    @Produces("application/json")
    public List<HistoryDTO> getHistorical(@QueryParam(value = "clientId") Long clientId,
                                @QueryParam(value = "purchaseId") Long purchaseId){
        List<HistoryDTO> hist;
        try{
            hist = clientSBLocal.getHistory(clientId, purchaseId);
            return hist;
        }catch(Exception e){
           
        }
        return null;
    }
    
    @GET
    @Path("/getPurchases/{clientId}")
    @Produces("application/json")
    public List<PurchaseDTO> getPurchases(@PathParam(value = "clientId") Long clientId) {
        List<PurchaseDTO> orders;
        try {
            orders = clientSBLocal.showOrders(clientId);
            if (orders == null) {
                return null;
            } else {
                return orders;
            }
        } catch (Exception ex) {
            
        }
        return null;
    }
    
    @PUT
    @Path("/confirmPurchase")
    @Produces("application/json")
    public Response confirmPurchase(
            @QueryParam(value = "clientId") Long clientId,
            @QueryParam(value = "purchaseId") Long purchaseId){
        Response response;
        try {
            clientSBLocal.confirmArrival(clientId, purchaseId);
            response = Response.ok().build();
        } catch (Exception e) {
            response = Response.serverError().entity(e).build();
        }
        return response;
    }
}
