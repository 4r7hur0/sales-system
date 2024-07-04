package main.system.model;

public class Electronics implements Product{
    private String type;
    private double price;

    public Electronics(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }
}
