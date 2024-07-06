package main.system.model;

public class ConcreteProductFactory {
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
