package main.system.model;

public interface OrderState {
    void next(Order order);
    String status();
}
