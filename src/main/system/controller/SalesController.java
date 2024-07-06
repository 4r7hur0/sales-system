package main.system.controller;

import main.system.facade.SalesFacade;
import main.system.model.Buyer;
import main.system.model.Seller;
import main.system.model.Stock;
import main.system.model.User;

import java.util.HashMap;
import java.util.LinkedList;

public class SalesController {
    private HashMap<String, User> mapUsers = new HashMap<>();
    private LinkedList<User> listUsers = new LinkedList<>();
    private User user; //usuário logado
    private Stock stock = new Stock();

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

    public User loginUser(String login, String senha) throws Exception {
        User u = mapUsers.get(login);
        if (u != null && u.getPassword().equals(senha))
            user = u;
        else
            throw new Exception("Login falhou");
        return u;
    }

    public void registerProduct(String type, double pryce, String description, int qtd) {
        if (user instanceof Seller);
        {
            Seller seller = (Seller) user;
            stock.addProduct(seller.registerProduct(type, pryce, description), qtd); //cria e adiciona ao estoque
        }
    }
}
