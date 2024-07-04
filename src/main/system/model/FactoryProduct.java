package main.system.model;

public interface FactoryProduct {
    Electronics makeEletronics(String type, double price);
    Clothes makeClothes(String type, double price);
    Foods makeFoods(String type, double price);
}
