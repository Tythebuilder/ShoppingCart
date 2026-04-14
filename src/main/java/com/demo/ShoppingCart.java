package com.demo;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();

    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty())
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative.");
        items.put(itemName, items.getOrDefault(itemName, 0.0) + price);
        System.out.println("Added: " + itemName + " for Rs." + price);
    }

    public void removeItem(String itemName) {
        if (!items.containsKey(itemName))
            throw new IllegalArgumentException("Item not found in cart: " + itemName);
        items.remove(itemName);
        System.out.println("Removed: " + itemName);
    }

    public double getTotal() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public int getItemCount() {
        return items.size();
    }

    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared.");
    }

    public static void main(String[] args) {
        System.out.println("=== Shopping Cart System ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple",  50.0);
        cart.addItem("Laptop", 45000.0);
        cart.addItem("Pen",    10.0);
        System.out.println("Total: Rs." + cart.getTotal());
        cart.removeItem("Pen");
        System.out.println("Total after remove: Rs." + cart.getTotal());
        System.out.println("Items in cart: " + cart.getItemCount());
    }
}