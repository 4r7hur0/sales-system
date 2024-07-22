package main.system.controller;

import main.system.model.*;
import main.system.model.exception.InsufficientQuantityException;
import main.system.model.exception.InvalidProductException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class SalesController {
    private HashMap<String, User> mapUsers = new HashMap<>();
    private LinkedList<User> listUsers = new LinkedList<>();
    private LinkedList<Order> allOrders = new LinkedList<>();
    private User user; //usuário logado
    private Stock stock = new Stock();

    public void registerUser(String name, String login, String password, String email, String address, int payment){
        if (payment != 0) {
            User buyer = new Buyer(name, login, password, email, address);
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

    public String getNameUser(){
        return this.user.getName();
    }

 dev
    public void registerProduct(String type, double pryce, String description, int qtd) {
        StockInterface stockProxy = new StockProxy(this.stock, this.user);
        if (user instanceof Seller);
        {
            Seller seller = (Seller) user;
            Product product = seller.registerProduct(type, pryce, description);
            stockProxy.addProduct(product, qtd);

    public void registerProduct(String type, double price, String description, int qtd) {
        if (user instanceof Seller);
        {
            Seller seller = (Seller) user;
            this.stock.addProduct(seller.registerProduct(type, price, description), qtd); //cria e adiciona ao estoque
 master
        }
    }

    public Map<Product, Integer> getAllProducts(){
        return this.stock.getAllProducts();
    }

    //método para remover do estoque
    public void removeProduct(Product product) {
        StockInterface stockProxy = new StockProxy(this.stock, this.user);
        stockProxy.removeProduct(product, this.stock.getQuantity(product));;
    }

    public void addInCart(Product product) {
        this.user.addInCart(product);
    }

    public Map<Product, Integer> viewCart() {
        return this.user.viewCart();
    }

    public double getTotalPrice() {
        return this.user.getTotalPrice();
    }

    public void order() {
        Order order = this.user.getCart().checkout();
        this.user.addOrder(order);
        this.allOrders.add(order);
    }

    public Iterator<Order> viewOrder() {
        return this.user.getOrders();
    }

    public PaymentMethod credit(String num, String name, String cvv) {
        PaymentMethod payment = new CreditCardPayment(num, name, cvv);
        this.user.getCart().setPaymentMethod(payment);
        return payment;
    }

    public PaymentMethod payPal(String email) {
        PaymentMethod payment = new PayPalMethod(email);
        this.user.getCart().setPaymentMethod(payment);
        return payment;
    }

    public PaymentMethod bankTransfer(String num, String name, String ag) {
        PaymentMethod payment = new BankTransferPayment(num, ag, name);
        this.user.getCart().setPaymentMethod(payment);
        return payment;
    }

    public void modifyStatus(Order order) {
        order.nextStatus();
    }

    public Iterator<Order> viewAllOrders() {
        return this.allOrders.iterator();
    }

    public void removeProductCart(Product product){
        this.user.getCart().removeItem(product);
    }
}
