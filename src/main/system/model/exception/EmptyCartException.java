package main.system.model.exception;

public class EmptyCartException extends Exception{
    public EmptyCartException() {
        super();
    }

    public EmptyCartException(String massage) {
        super(massage);
    }
}
