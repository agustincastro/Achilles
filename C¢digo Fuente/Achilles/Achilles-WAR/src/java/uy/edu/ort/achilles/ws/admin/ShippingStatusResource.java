package uy.edu.ort.achilles.ws.admin;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import uy.edu.ort.achilles.persistence.entities.ShippingStatus;
import uy.edu.ort.achilles.persistence.managers.ShippingStatusManagerSBLocal;

@Path("/shippingStatus")
@Stateless
public class ShippingStatusResource {
   
    @EJB
    private ShippingStatusManagerSBLocal sb;

    public ShippingStatusResource() {
    }

    @GET
    @Produces("application/json")
    public List<ShippingStatus> getShippingStatus() {
        List<ShippingStatus> aux = sb.getShippingStatus();
        return aux;
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ShippingStatus postJson(ShippingStatus shippingStatus){
        sb.newStatus(shippingStatus);
        return shippingStatus;
    }
}
