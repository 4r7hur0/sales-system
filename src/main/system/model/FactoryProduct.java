package main.system.model;

import java.io.Serializable;

public interface FactoryProduct {
    Product makeProduct(String type, double price, String description);
}
