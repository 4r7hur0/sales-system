package main.system.facade;

import main.system.controller.SalesController;
import main.system.model.*;

import main.system.model.Order;
import main.system.model.Product;
import main.system.model.User;
import main.system.model.exception.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SalesFacade implements Serializable {
    SalesController sb;

    public SalesFacade(){
        this.sb = SalesController.getInstance();
    }

    public void registerUser(String name, String login, String password, String email, String address, int payment){
        this.sb.registerUser(name, login, password, email, address, payment);
    }

    public User loginUser(String login, String senha) throws LoginFailedException {
        return this.sb.loginUser(login , senha);
    }

    public String getNameUser(){
        return this.sb.getNameUser();
    }

    public void registerProduct(String type, String description, double pryce, int qtd) throws InvalidProductException {
        this.sb.registerProduct(type, pryce, description, qtd);
    }

    public Map<Product, Integer> getAllProducts(){
        return this.sb.getAllProducts();
    }

    public void removeProduct(Product product) {
        this.sb.removeProduct(product);
    }

    public void addInCart(Product product) {
        this.sb.addInCart(product);
    }

    public Map<Product, Integer> viewCart() {
        return this.sb.viewCart();
    }
    public double getTotalPrice() {
        return this.sb.getTotalPrice();
    }

    public void order() throws EmptyCartException, InsufficientQuantityException, PaymentMethodNotDefinedException {
        this.sb.order();
    }

    public MyIterator<Order> viewOrder(){
        return this.sb.viewOrder();
    }

    public PaymentMethod credit(String num, String name, String cvv) {
        return this.sb.credit(num, name, cvv);
    }

    public PaymentMethod payPal(String email) {
        return this.sb.payPal(email);
    }

    public PaymentMethod bankTransfer(String num, String ag, String name) {
        return this.sb.bankTransfer(num, name, ag);
    }

    public MyIterator<Order> viewAllOrders() {
        return this.sb.viewAllOrders();
    }

    public void modifyStatus(Order order) {
        this.sb.modifyStatus(order);
    }

    public void removeProductCart(Product product){
        this.sb.removeProductCart(product);
    }

    public HashMap<String, User> getMapUsers() {
        return this.sb.getMapUsers();
    }

    public LinkedList<User> getListUsers() {
        return this.sb.getListUsers();
    }

    public LinkedList<Order> getListOrder() {
        return this.sb.getListOrder();
    }

    public void setMapUsers(HashMap<String, User> mapUsers){
        this.sb.setMapUsers(mapUsers);
    }

    public void setListUsers(LinkedList<User> listUsers) {
        this.sb.setListUsers(listUsers);
    }

    public void setAllOrders(LinkedList<Order> orders){
        this.sb.setAllOrders(orders);
    }

    public Stock getStock() {
        return this.sb.getStock();
    }

    public void setStock(Stock stock) {
        this.sb.setStock(stock);
    }

}
