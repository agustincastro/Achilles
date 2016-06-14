package uy.edu.ort.achilles.ws.carrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import uy.edu.ort.achilles.carrier.businesslogic.CarrierSBLocal;


@Path("/carrier")
@Stateless
public class CarrierResource {
    @EJB
    private QueueSenderSB queuesender;
    @EJB 
    private CarrierSBLocal carriersb;
    
    public CarrierResource() {
    }

   
    @GET
    @Produces("application/json")
    public String getJson() {
        throw new UnsupportedOperationException();
    }

    
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
   @PUT
    @Path("/statusUpdateAsync")
    @Produces("application/json")
    public Response statusRefreshAsync(
            @QueryParam(value = "carrierId") Long carrierId,
            @QueryParam(value = "purchaseId") Long purchaseId,
            @QueryParam(value = "nextStatusId") Long shippingId, 
            @QueryParam(value = "note") String note) {
        Response response;
        try {
            queuesender.sendToQueue(carrierId, purchaseId, shippingId, note);
            response = Response.ok().build();
        } catch (Exception e) {
            response = Response.serverError().entity(e).build();
        }
        return response;
    }
    
    @PUT
    @Path("/statusUpdate")
    @Produces("application/json")
    public Response statusRefresh(
            @QueryParam(value = "carrierId") Long carrierId,
            @QueryParam(value = "purchaseId") Long purchaseId,
            @QueryParam(value = "nextStatusId") Long shippingId,
            @QueryParam(value = "note") String note){
        Response response;
        try {
            carriersb.updateShippingStatus(carrierId, purchaseId, shippingId,note);
            response = Response.ok().build();
        } catch (Exception e) {
            response = Response.serverError().entity(e).build();
        }
        return response;
    }
    
    
    
}
