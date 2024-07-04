package main.system.model;

public class Foods implements Product {
    private String description;
    private String type;
    private double price;

    public Foods(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
