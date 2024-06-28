package main.system.facade;

import main.system.controller.SalesController;
import main.system.model.User;

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
}
