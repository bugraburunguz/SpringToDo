package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasketTest {
    final Basket sepet = new Basket();
    final Product saat = new Product(1, "Saat", 200);
    final Product kabak = new Product(2, "Kabak", 5);
    final Product nike = new Product(1, "nike air", 180);
    final Product adidas = new Product(5, "Adidas", 165);

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {


        sepet.addItem(new BasketItem(1, nike));

        assertTrue(sepet.getItems().size() == 1);
        assertTrue(sepet.getItems().get(0).getProduct().equals(nike));

    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {

        //TODO


        sepet.addItem(new BasketItem(2, adidas));

        assertTrue(sepet.getItems().size() == 1);
        for (int i = 0; i < sepet.getItems().size(); i++) {
            assertTrue(sepet.getItems().get(i).getQuantity() == 2);
        }
    }


    @Test
    public void shouldAddTwoDifferentProduct() throws Exception {
        //TODO


        sepet.addItem(new BasketItem(4, saat));
        sepet.addItem(new BasketItem(5, kabak));


        assertTrue(sepet.getItems().size() == 2);

    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductOneQuantity() throws Exception {

        //TODO

        sepet.addItem(new BasketItem(1, nike));
        int price = sepet.calculateBasketPrice();

        assertTrue(price == 180);

    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductTwoQuantity() throws Exception {

        //TODO

        sepet.addItem(new BasketItem(2, saat));
        int price = sepet.calculateBasketPrice();


        assertTrue(price == 400);

    }

    @Test
    public void shouldCalculateBasketPriceWithMultipleProduct() throws Exception {
        //TODO
        sepet.addItem(new BasketItem(1, saat));
        sepet.addItem(new BasketItem(1, adidas));
        int price = sepet.calculateBasketPrice();


        assertTrue(price == 365);
    }

    @Test
    public void shouldUpdateBasketItemQuantity() throws Exception {
        //TODO
        final BasketItem basketItem = new BasketItem(5, saat);

        sepet.addItem(new BasketItem(1, saat));
        sepet.getItems().set(0, basketItem);

        assertTrue(sepet.getItems().get(0).getQuantity() == 5);
        assertTrue(sepet.getItems().size() == 1);
    }

}