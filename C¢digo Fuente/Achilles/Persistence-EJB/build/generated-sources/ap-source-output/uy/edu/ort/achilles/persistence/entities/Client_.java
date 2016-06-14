package uy.edu.ort.achilles.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.achilles.persistence.entities.Purchase;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T18:30:10")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Long> id;
    public static volatile ListAttribute<Client, Purchase> purchases;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, String> enterprise;
    public static volatile SingularAttribute<Client, String> type;

}