package main.system.model;

public class Buyer extends User {
    private FactoryProduct factoryProduct = (FactoryProduct) new ConcreteProductFactory();

    public Buyer(String name, String login, String password, String email, String address, int payment){
        super(name, login, password, email, address, payment);
    }

    public Product registerProduct(String type, double price, String description){
        return factoryProduct.makeProduct(type, price, description);
    }
}
