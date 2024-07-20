package main.system.model;

public class ShippedState implements OrderState{

    @Override
    public void next(Order order) {
        order.setStatus(new DeliveredState());
    }

    @Override
    public String status() {
        return "A caminho";
    }
}
