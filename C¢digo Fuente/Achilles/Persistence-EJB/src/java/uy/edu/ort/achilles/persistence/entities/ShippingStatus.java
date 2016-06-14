package uy.edu.ort.achilles.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SHIPPING_STATUS")
public class ShippingStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="NEXT_STATUS")
    private List<String> nextStatus;
    
    @Column(name="AUTHORIZED_CARRIER")
    @NotNull
    private Boolean authorizedCarrier;
    
    @Column(name="AUTHORIZED_CLIENT")
    @NotNull
    private Boolean authorizedClient;

    public ShippingStatus() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(List<String> nextStatus) {
        this.nextStatus = nextStatus;
    }

    public Boolean isAuthorizedCarrier() {
        return authorizedCarrier;
    }

    public void setAuthorizedCarrier(Boolean authorizedCarrier) {
        this.authorizedCarrier = authorizedCarrier;
    }

    public Boolean isAuthorizedClient() {
        return authorizedClient;
    }

    public void setAuthorizedClient(Boolean authorizedClient) {
        this.authorizedClient = authorizedClient;
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
        if (!(object instanceof ShippingStatus)) {
            return false;
        }
        ShippingStatus other = (ShippingStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.prueba.entities.ShippingStatus[ id=" + id + " ]";
    }
    
}
