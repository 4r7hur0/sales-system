package main.system.model;

public class foods implements Product {
    private String type;
    private double price;

    public foods(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
