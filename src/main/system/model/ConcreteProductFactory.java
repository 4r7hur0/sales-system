package main.system.model;

import java.io.Serializable;

public class ConcreteProductFactory implements FactoryProduct, Serializable {
    public Product makeProduct (String type, double price, String description) {
        switch (type.toLowerCase()) {
            case "eletronic":
                return new Electronics(type, price, description);
            case "clothing":
                return new Clothes(type, price, description);
            case "food":
                return new Foods(type, price, description);
            default:
                return null;
        }
    }
}
