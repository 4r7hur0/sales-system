package main.system.model;

import java.io.Serializable;

public class Electronics implements Product, Serializable {
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

    @Override
    public String toString() {
        return description;
    }
}


