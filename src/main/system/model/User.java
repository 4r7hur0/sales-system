package main.system.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class User {
    private String name;
    private String login;
    private String password;
    private String email;
    private String address;
    private int payment; //forma de pagamento - 1 cartão de credito; 2 PayPal; 3 transferência bancâria
    //se for diferente disso, então o usuário é um vendedor
    private ShppingCart cart = new ShppingCart();

    public User (String name, String login, String password, String email, String address, int payment) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.payment = payment;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.login;
    }

    public void addInCart(Product product) {
        cart.addItem(product);
    }

    public Map<Product, Integer> viewCart() {
        return cart.getItems();
    }

    public double getTotalPrice() {
        return this.cart.getTotalPrice();
    }

    public ShppingCart getCart(){
        return this.cart;
    }
}
