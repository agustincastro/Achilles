package uy.edu.ort.achilles.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.achilles.persistence.entities.ShippingOption;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T18:30:10")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, Long> id;
    public static volatile SingularAttribute<Article, String> unit;
    public static volatile SingularAttribute<Article, Float> price;
    public static volatile SingularAttribute<Article, Integer> stock;
    public static volatile SingularAttribute<Article, String> description;
    public static volatile SingularAttribute<Article, String> name;
    public static volatile ListAttribute<Article, ShippingOption> shippingOptions;
    public static volatile SingularAttribute<Article, Boolean> active;

}