package uy.edu.ort.achilles.carrier.exceptions;


public class CarrierException extends Exception {
     private String exceptionName;
     private String exceptionMessage;

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public CarrierException(String exceptionName, String exceptionMessage) {
        this.exceptionName = exceptionName;
        this.exceptionMessage = exceptionMessage;
    }
    
    public CarrierException(){
    
    }
    
     @Override
    public String toString() {
        return "Achilles Carrier Exception{" + "exception name = " + exceptionName + ", description = " + exceptionMessage + '}';
    }
     
}
