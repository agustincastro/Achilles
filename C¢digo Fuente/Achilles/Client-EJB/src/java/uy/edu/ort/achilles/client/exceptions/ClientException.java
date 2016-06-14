package uy.edu.ort.achilles.client.exceptions;


public class ClientException extends Exception {
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
     
    public ClientException(String exceptionName, String exceptionMessage){
        this.exceptionName = exceptionMessage;
        this.exceptionMessage = exceptionMessage;
    } 
    
    @Override
    public String toString() {
        return "Achilles Client Exception{" + "exception name = " + exceptionName + ", description = " + exceptionMessage + '}';
    }
}
