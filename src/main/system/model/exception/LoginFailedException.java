package main.system.model.exception;


public class LoginFailedException extends Exception{
    public LoginFailedException () {
        super();
    }

    public LoginFailedException (String massage) {
        super(massage);
    }
}
