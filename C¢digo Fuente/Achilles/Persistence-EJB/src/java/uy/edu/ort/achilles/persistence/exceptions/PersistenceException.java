package uy.edu.ort.achilles.persistence.exceptions;


public class PersistenceException extends Exception{
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

    public PersistenceException(String exceptionName, String exceptionMessage) {
        this.exceptionName = exceptionName;
        this.exceptionMessage = exceptionMessage;
    }
    
    public PersistenceException(){
    }
    
    @Override
    public String toString() {
        return "Achilles Converter Exception{" + "exception name = " + exceptionName + ", description = " + exceptionMessage + '}';
    }   
}
