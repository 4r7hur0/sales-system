package main.system.model.exception;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String massge) {
        super(massge);
    }
}
