package main.system.model.exception;

public class PaymentMethodNotDefinedException extends Exception{
    public PaymentMethodNotDefinedException() {
        super();
    }

    public PaymentMethodNotDefinedException(String massage) {
        super(massage);
    }
}
