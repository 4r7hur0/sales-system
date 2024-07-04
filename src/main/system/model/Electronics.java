package main.system.model;

public class Electronics implements Product{
    private String description;
    private String type;
    private double price;

    public Electronics(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }
}


