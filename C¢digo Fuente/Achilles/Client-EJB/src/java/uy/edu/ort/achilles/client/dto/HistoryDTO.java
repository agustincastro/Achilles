package uy.edu.ort.achilles.client.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HistoryDTO {
    private Date date;
    public String notes;
    public String place;
    public String enterprice;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEnterprice() {
        return enterprice;
    }

    public void setEnterprice(String enterprice) {
        this.enterprice = enterprice;
    }


    
}
