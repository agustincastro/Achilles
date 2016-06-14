package uy.edu.ort.achilles.converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import javax.ejb.Stateless;
import uy.edu.ort.achilles.converter.exceptions.ConverterException;

@Stateless
public class CurrencyConverterSB implements CurrencyConverterSBLocal {

    @Override
    public float convert(String currencyFrom, String currencyTo) throws ConverterException {
        try {
            URL yahoo = new URL("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv");
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxycen.ort.edu.uy", 80));
            HttpURLConnection con = (HttpURLConnection) yahoo.openConnection(proxy);
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("The conversion coeficient is: " + response.toString());
            return Float.parseFloat(response.toString());

        } catch (Exception e) {
            ConverterException ex = new ConverterException(e.getClass().getName(), "Converter exception when connecting with yahooFinance API");
            throw ex;
        }
    }
}
