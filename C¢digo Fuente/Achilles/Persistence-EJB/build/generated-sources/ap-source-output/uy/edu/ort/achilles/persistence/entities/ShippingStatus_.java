package uy.edu.ort.achilles.persistence.entities;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T18:30:10")
@StaticMetamodel(ShippingStatus.class)
public class ShippingStatus_ { 

    public static volatile SingularAttribute<ShippingStatus, Long> id;
    public static volatile SingularAttribute<ShippingStatus, Boolean> authorizedCarrier;
    public static volatile SingularAttribute<ShippingStatus, Boolean> authorizedClient;
    public static volatile SingularAttribute<ShippingStatus, String> name;
    public static volatile SingularAttribute<ShippingStatus, List> nextStatus;

}