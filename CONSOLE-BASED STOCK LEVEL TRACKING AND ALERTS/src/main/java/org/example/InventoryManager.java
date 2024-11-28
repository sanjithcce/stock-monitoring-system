package org.example;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Stock> inventory = new HashMap<>();

    public void addProduct(String productId, String productName, int quantity) {
        Stock stock = new Stock(productId, productName, quantity);
        inventory.put(productId, stock);
        System.out.println("Product added: " + stock);
    }

    public void updateStock(String productId, int quantity) {
        Stock stock = inventory.get(productId);
        if (stock != null) {
            stock.setQuantity(quantity);
            System.out.println("Stock updated: " + stock);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void viewProduct(String productId) {
        Stock stock = inventory.get(productId);
        if (stock != null) {
            System.out.println(stock);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void viewAllProducts() {
        System.out.println("Inventory:");
        for (Stock stock : inventory.values()) {
            System.out.println(stock);
        }
    }

    public void removeProduct(String productId) {
        Stock stock = inventory.remove(productId);
        if (stock != null) {
            System.out.println("Product removed: " + stock);
        } else {
            System.out.println("Product not found!");
        }
    }
}
