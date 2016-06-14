package uy.edu.ort.achilles.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.achilles.persistence.entities.Purchase;
import uy.edu.ort.achilles.persistence.entities.ShippingStatus;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T18:30:10")
@StaticMetamodel(History.class)
public class History_ { 

    public static volatile SingularAttribute<History, Long> id;
    public static volatile SingularAttribute<History, ShippingStatus> status;
    public static volatile SingularAttribute<History, String> enterprise;
    public static volatile SingularAttribute<History, Purchase> purchase;
    public static volatile SingularAttribute<History, Date> date;
    public static volatile SingularAttribute<History, String> place;
    public static volatile SingularAttribute<History, String> user;
    public static volatile SingularAttribute<History, String> note;

}