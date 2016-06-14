package uy.edu.ort.achilles.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="HISTORICAL")
public class History implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="STATUS_ID")
    private ShippingStatus status;
    
    @ManyToOne
    @JoinColumn(name="PURCHASE_ID")
    private Purchase purchase;
    
    @Column(name="USER_NAME")
    private String user;
    
    @Column(name="DATE_TIME")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @Column(name="PLACE")
    private String place;
    
    @Column(name="NOTE")
    private String note;
    
    @Column(name="ENTERPRISE")
    private String enterprise;

    public History(){
    }

    public History(Purchase purchase, ShippingStatus status, String user, String place, String note, String enterprise) {
        this.status = status;
        this.user = user;
        this.place = place;
        this.note = note;
        this.enterprise = enterprise;
        this.purchase = purchase;
        Date now = new Date();
        this.date = now;
    }
    
  
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.achilles.entities.History[ id=" + id + " ]";
    }
    
}
