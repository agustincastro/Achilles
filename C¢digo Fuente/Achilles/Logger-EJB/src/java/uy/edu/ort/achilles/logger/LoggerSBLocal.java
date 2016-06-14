
package uy.edu.ort.achilles.logger;

import javax.ejb.Local;
import org.apache.log4j.Logger;
import uy.edu.ort.achilles.logger.exceptions.LoggerException;


@Local
public interface LoggerSBLocal {
  
    void createLog() throws LoggerException;
    
    Logger getLogger(); 
}
