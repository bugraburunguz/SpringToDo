package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BasketServiceTest {
    BasketService basketService = new BasketService();
    final ProductService productService = new ProductService();
    final Basket basket = new Basket();
    final Product nike = new Product(1, "Nike", 200);
    final Product televizyon = new Product(2, "Televizyon", 400);
    final Product araba = new Product(3, "Araba", 100);

    @Test
    public void shouldCreateBasket() throws Exception {
        //TODO


        basketService.createBasket();


    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        //TODO


        basket.addItem(new BasketItem(1, productService.findBy(1)));


    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO


        basket.addItem(new BasketItem(2, productService.findBy(1)));
    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO

        final ProductService urun1 = new ProductService();
        final ProductService urun2 = new ProductService();

        basket.addItem(new BasketItem(1, urun1.findBy(1)));
        basket.addItem(new BasketItem(2, urun2.findBy(2)));
    }

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO


        basketService.addProduct(araba, 1);


        basketService.removeProduct(araba);


        assertTrue(basketService.getBasket().getItems().size() == 0);

    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO


        for (int i = 5; i > 10; i++) {
            basket.addItem(new BasketItem(i, productService.findBy(1)));
        }
    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO

        for (int i = 0; i > 5; i--) {
            basket.addItem(new BasketItem(i, productService.findBy(1)));
        }
    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO


        basketService.addProduct(araba, 3);
        basketService.decrementQuantity(araba, 3);


        assertTrue(basketService.getBasket().getItems().size() == 2);

    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı

        basketService.addProduct(araba, 4);
        basketService.addProduct(televizyon, 1);

        basketService.removeProduct(araba);
        basketService.removeProduct(televizyon);

        assertTrue(basketService.getBasketPrice() == 0);

    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali


        basketService.addProduct(araba, 3);


        assertTrue(basket.calculateBasketPrice() == 300);


    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali


        basketService.addProduct(televizyon, 1);
        basketService.addProduct(nike, 1);


        assertTrue(basketService.getBasketPrice() == 600);
    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        //TODO sepette 1 urun varken sayisi arttirildiginda price hesaplanmali


        Product elma = new Product(1, "Elma", 3);
        BasketItem basketItem = new BasketItem(1, elma);
        basket.addItem(basketItem);
        basketService.incrementQuantity(elma, 2);

    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        //TODO sepette 1 urun varken sayisi azaltildiginda price hesaplanmali

        Product silah = new Product(1, "Silah", 150);
        BasketItem basketItem = new BasketItem(1, silah);
        basket.addItem(basketItem);
        assertTrue(basket.calculateBasketPrice().equals(150));


    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi arttirma isleminden sonra price hesaplanmali

        Product galate = new Product(1, "Galate", 1);
        BasketItem galateItem = new BasketItem(5, galate);
        basket.addItem(galateItem);
        Product tekirdagkofte = new Product(2, "Tekirdağ Köfte", 2);
        BasketItem tekirdagkofteItem = new BasketItem(18, tekirdagkofte);
        basket.addItem(tekirdagkofteItem);

    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali


        Product erik = new Product(1, "Erik", 3);
        Product elma = new Product(2, "Elma", 4);
        Product armut = new Product(3, "Armut", 6);
        Product patates = new Product(4, "Patates", 1);

        BasketItem erikSepet = new BasketItem(25, erik);
        BasketItem elmaSepet = new BasketItem(4, elma);
        BasketItem armutSepet = new BasketItem(25, armut);
        BasketItem patatesSepet = new BasketItem(4, patates);

        basket.addItem(erikSepet);
        basket.addItem(elmaSepet);
        basket.addItem(armutSepet);
        basket.addItem(patatesSepet);
    }


}