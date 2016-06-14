package uy.edu.ort.achilles.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHIPPING_OPTION")
public class ShippingOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    
    @Column(name="PERCENTAGE")
    private int percentage;
    
    @Column(name="PRICE")
    private int price;
    
    @Column(name="MNIMUM_TIME")
    private int minimumTime;
    
    @Column(name="MAXIMUM_TIME")
    private int maximumTime;
    
    
    public ShippingOption(int price, int percentage, int minimumTime, int maximumTime){
        this.percentage = percentage;
        this.maximumTime = maximumTime;
        this.minimumTime = minimumTime;
        this.price = price;
    }
    
    public ShippingOption(){
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    public int getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(int maximumTime) {
        this.maximumTime = maximumTime;
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
        if (!(object instanceof ShippingOption)) {
            return false;
        }
        ShippingOption other = (ShippingOption) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.entities.ShippingOption[ id=" + id + " ]";
    }
    

}
