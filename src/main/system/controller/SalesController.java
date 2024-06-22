package main.system.controller;

import main.system.model.Buyer;
import main.system.model.Seller;
import main.system.model.User;

import java.util.HashMap;
import java.util.LinkedList;

public class SalesController {
    private HashMap<String, User> mapUsers = new HashMap<>();
    private LinkedList<User> listUsers = new LinkedList<>();
    private User user; //usuário logado

    public void registerUser(String name, String login, String password, String email, String address, int payment){
        if (payment != 0) {
            User buyer = new Buyer(name, login, password, email, address, payment);
            mapUsers.put(login, buyer);
            listUsers.add(buyer);
        }
        else {
            User seller = new Seller(name, login, password, email, address);
            mapUsers.put(login, seller);
            listUsers.add(seller);
        }
    }
}
