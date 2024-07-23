package main.system.facade;

import main.system.controller.SalesController;
import main.system.model.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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

    public String getNameUser(){
        return this.cb.getNameUser();
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
        this.cb.addInCart(product);
    }

    public Map<Product, Integer> viewCart() {
        return this.cb.viewCart();
    }
    public double getTotalPrice() {
        return this.cb.getTotalPrice();
    }

    public void order(){
        this.cb.order();
    }

    public Iterator<Order> viewOrder(){
        return this.cb.viewOrder();
    }

    public PaymentMethod credit(String num, String name, String cvv) {
        return this.cb.credit(num, name, cvv);
    }

    public PaymentMethod payPal(String email) {
        return this.cb.payPal(email);
    }

    public PaymentMethod bankTransfer(String num, String ag, String name) {
        return this.cb.bankTransfer(num, name, ag);
    }

    public Iterator<Order> viewAllOrders() {
        return this.cb.viewAllOrders();
    }

    public void modifyStatus(Order order) {
        this.cb.modifyStatus(order);
    }

    public void removeProductCart(Product product){
        this.cb.removeProductCart(product);
    }

    public HashMap<String, User> getMapUsers() {
        return this.cb.getMapUsers();
    }

    public LinkedList<User> getListUsers() {
        return this.cb.getListUsers();
    }

    public LinkedList<Order> getListOrder() {
        return this.cb.getListOrder();
    }

    public void setMapUsers(HashMap<String, User> mapUsers){
        this.cb.setMapUsers(mapUsers);
    }

    public void setListUsers(LinkedList<User> listUsers) {
        this.cb.setListUsers(listUsers);
    }

    public void setAllOrders(LinkedList<Order> orders){
        this.cb.setAllOrders(orders);
    }

    public Stock getStock() {
        return this.cb.getStock();
    }

    public void setStock(Stock stock) {
        this.cb.setStock(stock);
    }
}
