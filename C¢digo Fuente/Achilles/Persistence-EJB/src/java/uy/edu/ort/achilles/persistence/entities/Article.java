package uy.edu.ort.achilles.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLES")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="PRICE")
    private Float price;
    
    @Column(name="UNIT")
    private String unit;
    
    @Column(name="STOCK")
    private int stock;
    
    @Column(name="ACTIVE")
    private boolean active;
    
    @OneToMany
    private List<ShippingOption> shippingOptions;
    
    public Article(String name, String desc, Float price, String unit){
        this.name = name;
        this.description = desc;
        this.price = price;
        this.unit = unit;
        this.active = true;
    }
    
    public Article(){
    
    }
    
    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<ShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(List<ShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.entities.Articulo[ id=" + id + " ]";
    }
    
}
