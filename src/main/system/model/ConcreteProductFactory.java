package main.system.model;

public class ConcreteProductFactory {
    public Electronics createEletronic (String type, double price) {
        return new Electronics(type, price);
    }

    public Clothes createCloathes (String type, double price) {
        return new Clothes(type, price);
    }

    public Foods createFood (String type, double price) {
        return new Foods(type, price);
    }
}
