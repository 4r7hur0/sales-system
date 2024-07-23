package main.system.model;

import java.io.Serializable;

public class ShippedState implements OrderState, Serializable {

    @Override
    public void next(Order order) {
        order.setStatus(new DeliveredState());
    }

    @Override
    public String status() {
        return "A caminho";
    }
}
