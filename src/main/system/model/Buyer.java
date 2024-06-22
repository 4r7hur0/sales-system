package main.system.model;

public class Buyer extends User {
    public Buyer(String name, String login, String password, String email, String address, int payment){
        super(name, login, password, email, address, payment);
    }

    @Override
    public void registerProduct(){}
}
