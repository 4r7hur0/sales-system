package main.system.model;

public interface FactoryProduct {
    Product makeProduct(String type, double price, String description);
}
