package main.system.model;

import java.io.Serializable;

public class CreatingOrderState implements OrderState, Serializable {

    @Override
    public void next(Order order) {
        order.setStatus(new ShippedState());
    }

    @Override
    public String status() {
        return "Preparando pedido";
    }
}
