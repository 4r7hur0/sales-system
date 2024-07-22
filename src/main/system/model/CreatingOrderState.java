package main.system.model;

public class CreatingOrderState implements OrderState{

    @Override
    public void next(Order order) {
        order.setStatus(new ShippedState());
    }

    @Override
    public String status() {
        return "Preparando pedido";
    }
}
