package main.system.model.exception;

public class InvalidProductException extends Exception{
    public InvalidProductException() {
        super();
    }

    public InvalidProductException(String massage) {
        super(massage);
    }
}
