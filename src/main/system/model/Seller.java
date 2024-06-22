package main.system.model;

import java.util.LinkedList;

public class Seller extends User {
    private LinkedList<Object> products = new LinkedList<>();

    public Seller(String name, String login, String password, String email, String address){
       super(name, login, password, email, address, 0);     //vendedor não tem forma de pagamento, já que não pode comprar
    }

    @Override
    public void registerProduct(){

    }
}
