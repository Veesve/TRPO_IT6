package lab4.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLParser {
    private static final String dataURL = "https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=%s";
    private Currency currency;

    //    static final String currencyName = "RUB";
    public String getPrice(String cryptoName, String currencyName) {

        String currenciesData = getJsonString(cryptoName, currencyName);
        parseJsonString(currencyName, currenciesData);
        JsonObject message = currency.getJsonObject();

        return message.toString();
    }


    private String getJsonString(String cryptoName, String currencyName) {
        try {
            URL currencyURL = new URL(String.format(dataURL, cryptoName, currencyName));
            URLConnection currencyURLCon = currencyURL.openConnection();
            BufferedReader streamURL = new BufferedReader(new InputStreamReader(currencyURLCon.getInputStream()));
            String currenciesData = streamURL.readLine();
            streamURL.close();
            return currenciesData;
        } catch (MalformedURLException e) {
            System.err.print("Error in URL");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print("Error while getting data");
            e.printStackTrace();
        }
        return null;
    }

    private void parseJsonString(String currencyName, String currenciesData) {
        try (JsonReader reader = Json.createReader(new StringReader(currenciesData))) {
            JsonObject jsonMessage = reader.readObject();
            double currencyValue = jsonMessage.getJsonNumber(currencyName).doubleValue();
            currency = new Currency(currencyName, currencyValue);
        }
    }
}