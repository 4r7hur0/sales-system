package main.system.facade;

import main.system.controller.SalesController;
import main.system.model.Product;
import main.system.model.User;

import java.util.Map;

public class SalesFacade {
    SalesController cb;

    public SalesFacade(){
        this.cb = new SalesController();
    }

    public void registerUser(String name, String login, String password, String email, String address, int payment){
        this.cb.registerUser(name, login, password, email, address, payment);
    }

    public User loginUser(String login, String senha) throws Exception {
        return this.cb.loginUser(login , senha);
    }

    public void registerProduct(String type, String description, double pryce, int qtd) {
        this.cb.registerProduct(type, pryce, description, qtd);
    }

    public Map<Product, Integer> getAllProducts(){
        return this.cb.getAllProducts();
    }

    public void removeProduct(Product product) {
        this.cb.removeProduct(product);
    }

    public void addInCart(Product product) {

    }
}
