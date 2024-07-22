package main.system.model;

public class DeliveredState implements OrderState{
    @Override
    public void next(Order order) {
        //não faz nada, pois está no estado final
    }

    @Override
    public String status() {
        return "Entregue";
    }
}
