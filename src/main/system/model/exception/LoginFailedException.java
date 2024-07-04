package main.system.model.exception;


public class LoginFailedException extends Exception{
    private String login;
    private String senha;

    public LoginFailedException(String login, String senha){
        super("Login ou senha incorreta!");
        this.login = login;
        this.senha = senha;
    }
}
