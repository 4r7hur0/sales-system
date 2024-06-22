package main.system.facade;

import main.system.controller.SalesController;

public class SalesFacade {
    SalesController cb;

    public SalesFacade(){
        this.cb = new SalesController();
    }

    public void registerUser(String name, String login, String password, String email, String address, int payment){
        this.cb.registerUser(name, login, password, email, address, payment);
    }
}
