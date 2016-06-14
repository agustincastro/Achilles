package uy.edu.ort.achilles.persistence.managers;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.achilles.persistence.entities.ShippingStatus;

@Local
public interface ShippingStatusManagerSBLocal {
    public void newStatus(ShippingStatus s);
    public List<ShippingStatus> getShippingStatus();
}
