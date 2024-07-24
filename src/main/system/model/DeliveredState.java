package main.system.model;

import java.io.Serializable;

public class DeliveredState implements OrderState, Serializable {
    @Override
    public void next(Order order) {
        //não faz nada, pois está no estado final
    }

    @Override
    public String status() {
        return "Entregue";
    }
}
