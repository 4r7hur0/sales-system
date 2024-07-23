package main.system.controller;

import main.system.model.*;
import main.system.model.exception.EmptyCartException;
import main.system.model.exception.InsufficientQuantityException;
import main.system.model.exception.InvalidProductException;
import main.system.model.exception.PaymentMethodNotDefinedException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SalesController implements Serializable {
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

    public void registerProduct(String type, double pryce, String description, int qtd) throws InvalidProductException {
        StockInterface stockProxy = new StockProxy(this.stock, this.user);
        if (user instanceof Seller) ;
        {
            Seller seller = (Seller) user;
            if (type == null || pryce < 0 || description == null || qtd <= 0) {
                throw new InvalidProductException();
            }
            Product product = seller.registerProduct(type, pryce, description);
            stockProxy.addProduct(product, qtd);
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

    public void removeItemStockOrder(Product product, int quantity) {
        this.stock.removeProduct(product, quantity);
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

    public void order() throws InsufficientQuantityException, EmptyCartException, PaymentMethodNotDefinedException {
        ShoppingCart shop = this.user.getCart();

        if (shop.getItems() == null) {
            throw new EmptyCartException();
        }

        if (shop.getPayment() == null) {
            throw new PaymentMethodNotDefinedException();
        }

        for (Map.Entry<Product, Integer> product: shop.getItems().entrySet()) {
            if (product.getValue() < stock.getQuantity(product.getKey())) {
                throw new InsufficientQuantityException();
            }
        }
        Order order = this.user.getCart().checkout();

        for (Map.Entry<Product, Integer> product: order.getItems().entrySet()) {
            this.removeItemStockOrder(product.getKey(), product.getValue());
        }
        this.user.addOrder(order);
        this.allOrders.add(order);
    }

    public MyIterator<Order> viewOrder() {
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

    public MyIterator<Order> viewAllOrders() {
        return new Iterator<>(allOrders);
    }

    public void removeProductCart(Product product){
        this.user.getCart().removeItem(product);
    }

    public HashMap<String, User> getMapUsers() {
        return this.mapUsers;
    }

    public LinkedList<User> getListUsers() {
        return this.listUsers;
    }

    public LinkedList<Order> getListOrder() {
        return this.allOrders;
    }

    public Stock getStock() {
        return this.stock;
    }

    public void setMapUsers(HashMap<String, User> mapUsers){
        this.mapUsers = mapUsers;
    }

    public void setListUsers(LinkedList<User> listUsers) {
        this.listUsers = listUsers;
    }

    public void setAllOrders(LinkedList<Order> orders){
        this.allOrders = orders;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
