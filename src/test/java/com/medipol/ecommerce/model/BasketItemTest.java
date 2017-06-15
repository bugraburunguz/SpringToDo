package com.medipol.ecommerce.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasketItemTest {

    @Test
    public void shouldCalculatePriceWhenQuantityIsOne() throws Exception {
        //TODO

        //create data

        final Product product = new Product(1, "jhk", 5);
        final BasketItem basketItem = new BasketItem(1, product);

        //action
        final Integer result = basketItem.price();

        //verify
        assertTrue(basketItem.getQuantity() == 1);
        assertTrue(result == 5);

    }

    @Test
    public void shouldCalculatePriceWhenQuantityIsThree() throws Exception {
        //TODO

        final Product salatalik = new Product(123, "Salatalık", 1);
        final BasketItem basketItem = new BasketItem(3, salatalik);

        //action
        final Integer result = basketItem.price();

        //verify
        assertTrue(basketItem.getQuantity() == 3);
        assertTrue(result == 3);
    }
}