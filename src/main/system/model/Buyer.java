package main.system.model;

import java.io.Serializable;

public class Buyer extends User implements Serializable {
    public Buyer(String name, String login, String password, String email, String address){
        super(name, login, password, email, address);
    }

    public double getTotalPrice() {
        return this.getCart().getTotalPrice();
    }
}
