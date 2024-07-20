package main.system.model;

public class Buyer extends User {
    public Buyer(String name, String login, String password, String email, String address){
        super(name, login, password, email, address);
    }

    public double getTotalPrice() {
        return this.getCart().getTotalPrice();
    }
}
