package uy.edu.ort.achilles.logger.exceptions;


public class LoggerException extends Exception{
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

    public LoggerException(String exceptionName, String exceptionMessage) {
        this.exceptionName = exceptionName;
        this.exceptionMessage = exceptionMessage;
    } 
}
