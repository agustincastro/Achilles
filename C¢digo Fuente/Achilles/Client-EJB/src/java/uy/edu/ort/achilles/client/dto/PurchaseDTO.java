package uy.edu.ort.achilles.client.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseDTO {
    private Date purchaseDate;
    private String article;
    private String purchaseState;
    private String estimatedTimeLeft;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }


    public String getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(String purchaseState) {
        this.purchaseState = purchaseState;
    }

    public String getEstimatedTimeLeft() {
        return estimatedTimeLeft;
    }

    public void setEstimatedTimeLeft(String estimatedTimeLeft) {
        this.estimatedTimeLeft = estimatedTimeLeft;
    }  
}
