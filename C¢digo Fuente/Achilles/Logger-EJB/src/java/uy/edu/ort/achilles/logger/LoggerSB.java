package uy.edu.ort.achilles.logger;

import java.net.URL;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import uy.edu.ort.achilles.logger.exceptions.LoggerException;

@Stateless
public class LoggerSB implements LoggerSBLocal {
    
    private static Logger logger = Logger.getLogger(LoggerSB.class);
    
    public LoggerSB(){
     URL url = LoggerSB.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
    }

    @Override
    public Logger getLogger() {
        return Logger.getLogger(LoggerSB.class);
    }
     
    
    @Override
    public void createLog() throws LoggerException {
        try {
            URL url = LoggerSB.class.getResource("Log4j.properties");
            PropertyConfigurator.configure(url);
        } catch (Exception e) {
            LoggerException ex = new LoggerException(e.getClass().getName(), "Exception when creating the log: " + e.toString());
            throw ex;
        }
    }  
}
