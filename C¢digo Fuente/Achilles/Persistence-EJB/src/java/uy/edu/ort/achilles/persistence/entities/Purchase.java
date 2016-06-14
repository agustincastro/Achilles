package uy.edu.ort.achilles.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="PURCHASE")
public class Purchase implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
     
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private Client client;
    
    @Column(name="PURCHASE_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
   
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="ARTICLE_ID")
    private Article article;
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="SHIPPING_OPTION_ID")
    private ShippingOption shippingOption;
    
    @Column(name="PURCHASE_STATE")
    private String purchaseState;
    
    @Column(name="ESTIMATED_TIME_LEFT")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date estimatedTimeLeft;
    
    @OneToMany(mappedBy="purchase", cascade=CascadeType.ALL)
    private List<History> historical;

    public Purchase(Client client, Article article, ShippingOption shippingOption){
        this.client = client;
        this.article = article;
        this.shippingOption = shippingOption;
        this.purchaseState = null;
        Date now = new Date();
        this.date = now;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, shippingOption.getMaximumTime());
        this.estimatedTimeLeft = c.getTime();
        historical = new ArrayList<>();
    }
    
    public Purchase(){
        historical = new ArrayList<>();
    }

    public List<History> getHistorical() {
        return historical;
    }

    public void setHistorical(List<History> historical) {
        this.historical = historical;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(String purchaseState) {
        this.purchaseState = purchaseState;
    }

    public Date getEstimatedTimeLeft() {
        return estimatedTimeLeft;
    }

    public void setEstimatedTimeLeft(Date estimatedTimeLeft) {
        this.estimatedTimeLeft = estimatedTimeLeft;
    }

    public ShippingOption getShippingOption() {
        return shippingOption;
    }

    public void setShippingOption(ShippingOption shippingOption) {
        this.shippingOption = shippingOption;
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
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.entities.Purchase[ id=" + id + " ]";
    }
    
}
