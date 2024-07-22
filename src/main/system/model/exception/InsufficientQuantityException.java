package main.system.model.exception;

public class InsufficientQuantityException extends Exception{
    public InsufficientQuantityException() {
        super();
    }

    public InsufficientQuantityException(String massage) {
        super(massage);
    }
}
