package main.system.model;


public class Seller extends User {
    private FactoryProduct factoryProduct = new ConcreteProductFactory();

    public Seller(String name, String login, String password, String email, String address){
       super(name, login, password, email, address);
    }

    @Override
    public double getTotalPrice() {
        return 0; //Vendedor não possui carrinho
    }

    public Product registerProduct(String type, double price, String description){
        return factoryProduct.makeProduct(type, price, description);
    }
}
