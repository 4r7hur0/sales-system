package main.system.model;

import java.util.LinkedList;
import java.util.List;

public class ShppingCart {
    private List<Product> items = new LinkedList<>();

    public void addItem(Product item) {
        ProductPackage existingPackage = null;

        for(Product existingItem: items) {
            if(existingItem instanceof ProductPackage) {
                ProductPackage productPackage = (ProductPackage) existingItem;
                existingPackage = productPackage;
                break;
            }
            else if(existingItem.getDescription().equals(item.getDescription())) {
                existingItem = new ProductPackage(item.getDescription());
                existingPackage.addProduct(existingItem);
                items.remove(existingItem);
                items.add(existingPackage);
                break;
            }
        }
        if(existingPackage != null) {
            existingPackage.addProduct(item);
        }
        else {
            items.add(item);
        }
    }

    public void removeItem(Product item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getItems() {
        return items;
    }

    public Order checkout() {
        Order order = new Order(new LinkedList<>(items));
        items.clear();
        return order;
    }
}
