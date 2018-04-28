package lab4.model;

import javax.json.JsonObject;
import javax.json.spi.JsonProvider;

public class Currency {

    private String name;
    private double price;

    public Currency(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public JsonObject getJsonObject() {
        JsonProvider provider = JsonProvider.provider();
        return provider.createObjectBuilder()
                .add("name", name)
                .add("price", price)
                .build();
    }

}