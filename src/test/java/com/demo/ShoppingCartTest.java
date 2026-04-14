package com.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItemAndTotal() {
        cart.addItem("Apple", 50.0);
        cart.addItem("Pen",   10.0);
        assertEquals(60.0, cart.getTotal(), 0.01);
    }

    @Test
    void testRemoveItem() {
        cart.addItem("Apple", 50.0);
        cart.addItem("Pen",   10.0);
        cart.removeItem("Pen");
        assertEquals(50.0, cart.getTotal(), 0.01);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testEmptyCartTotal() {
        assertEquals(0.0, cart.getTotal(), 0.01);
    }

    @Test
    void testClearCart() {
        cart.addItem("Apple",  50.0);
        cart.addItem("Laptop", 45000.0);
        cart.clearCart();
        assertEquals(0.0, cart.getTotal(), 0.01);
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void testRemoveNonExistentItem() {
        assertThrows(IllegalArgumentException.class, () -> cart.removeItem("Ghost Item"));
    }

    @Test
    void testNegativePriceRejected() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("BadItem", -100.0));
    }

    @Test
    void testInvalidItemName() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 100.0));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 100.0));
    }
}