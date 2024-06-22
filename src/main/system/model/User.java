package main.system.model;

public abstract class User {
    private String name;
    private String login;
    private String password;
    private String email;
    private String address;
    private int payment; //forma de pagamento - 1 cartão de credito; 2 PayPal; 3 transferência bancâria

    public User (String name, String login, String password, String email, String address, int payment) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.payment = payment;
    }

    public abstract void registerProduct();
}
