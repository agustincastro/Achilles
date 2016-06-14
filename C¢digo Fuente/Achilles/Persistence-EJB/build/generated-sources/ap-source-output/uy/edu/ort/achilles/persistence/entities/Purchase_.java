package uy.edu.ort.achilles.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.achilles.persistence.entities.Article;
import uy.edu.ort.achilles.persistence.entities.Client;
import uy.edu.ort.achilles.persistence.entities.History;
import uy.edu.ort.achilles.persistence.entities.ShippingOption;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T18:30:10")
@StaticMetamodel(Purchase.class)
public class Purchase_ { 

    public static volatile SingularAttribute<Purchase, Long> id;
    public static volatile SingularAttribute<Purchase, ShippingOption> shippingOption;
    public static volatile SingularAttribute<Purchase, Client> client;
    public static volatile SingularAttribute<Purchase, Article> article;
    public static volatile SingularAttribute<Purchase, Date> estimatedTimeLeft;
    public static volatile ListAttribute<Purchase, History> historical;
    public static volatile SingularAttribute<Purchase, Date> date;
    public static volatile SingularAttribute<Purchase, String> purchaseState;

}