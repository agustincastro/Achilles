package uy.edu.ort.achilles.persistence.managers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.achilles.persistence.entities.ShippingStatus;

@Stateless
public class ShippingStatusManagerSB implements ShippingStatusManagerSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void newStatus(ShippingStatus s) {
        em.persist(s);
    }

    @Override
    public List<ShippingStatus> getShippingStatus() {
        Query query = em.createQuery("SELECT status from ShippingStatus status");
        List<ShippingStatus> shippingStatus = query.getResultList();
        for (ShippingStatus s:shippingStatus) {
            System.out.println(s.getName());
        }
        return shippingStatus;
    }
}
