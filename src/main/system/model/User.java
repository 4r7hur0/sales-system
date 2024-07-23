package main.system.model;

import java.io.Serializable;
import java.util.*;

public abstract class User implements Serializable {
    private String name;
    private String login;
    private String password;
    private String email;
    private String address;
    private ShppingCart cart = new ShppingCart();
    private LinkedList<Order> orders = new LinkedList<>();

    public User (String name, String login, String password, String email, String address) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
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

    public abstract double getTotalPrice();

    public ShppingCart getCart(){
        return this.cart;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public Iterator<Order> getOrders(){
        return this.orders.iterator();
    }
}
