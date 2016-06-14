package uy.edu.ort.achilles.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T18:30:10")
@StaticMetamodel(ShippingOption.class)
public class ShippingOption_ { 

    public static volatile SingularAttribute<ShippingOption, Long> id;
    public static volatile SingularAttribute<ShippingOption, Integer> price;
    public static volatile SingularAttribute<ShippingOption, Integer> minimumTime;
    public static volatile SingularAttribute<ShippingOption, Integer> percentage;
    public static volatile SingularAttribute<ShippingOption, Integer> maximumTime;

}