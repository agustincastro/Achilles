
package uy.edu.ort.achilles.converter;

import javax.ejb.Local;
import uy.edu.ort.achilles.converter.exceptions.ConverterException;

@Local
public interface CurrencyConverterSBLocal {
    public float convert(String currencyFrom, String currencyTo) throws ConverterException;
}
