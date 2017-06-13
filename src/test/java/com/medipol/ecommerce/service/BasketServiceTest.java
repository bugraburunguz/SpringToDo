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
    @Test
    public void shouldCreateBasket() throws Exception {
        //TODO



        basketService.createBasket();


    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        //TODO

        final Basket basket = new Basket();

        basket.addItem(new BasketItem(1, productService.findBy(1)));


    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO

        final Basket basket = new Basket();
        basket.addItem(new BasketItem(2, productService.findBy(1)));
    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO
        final Basket basket = new Basket();
        final ProductService urun1 = new ProductService();
        final ProductService urun2 = new ProductService();

        basket.addItem(new BasketItem(1, urun1.findBy(1)));
        basket.addItem(new BasketItem(2, urun2.findBy(2)));
    }

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO

        BasketService basketService = new BasketService();

        final Basket basket = new Basket();
        Product kulaklık = new Product(3,"Kulaklık",3);

        BasketItem basketItem = new BasketItem(2,kulaklık);
        basket.addItem(basketItem);

        basketService.removeProduct(kulaklık);

    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO
        final Basket basket = new Basket();

        for(int i = 0; i>2; i++) {
            basket.addItem(new BasketItem(i, productService.findBy(1)));
        }
    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO
        final Basket basket = new Basket();

        for(int i = 2; i<0; i--) {
            basket.addItem(new BasketItem(i, productService.findBy(1)));
        }
    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO

        Product product = new Product(11,"Oyuncak Kamyon",3);
        Basket basket = new Basket();
        BasketItem basketItem = new BasketItem(2,product);
        basket.addItem(basketItem);
        BasketService basketService = new BasketService();
        basketService.decrementQuantity(product,1);

    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı

    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali
        Basket basket = new Basket();
        Product product = new Product(10,"Elma",3);
        BasketItem basketItem = new BasketItem(3,product);

        basket.addItem(basketItem);


        assertTrue(basket.calculateBasketPrice()==9);



    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali

        Basket basket = new Basket();
        Product product = new Product(11,"Soğan",2);
        Product product2 = new Product(12,"Kivi",2);

        BasketItem basketItem = new BasketItem(2,product);
        BasketItem basketItem2 = new BasketItem(2,product2);

        basket.addItem(basketItem);
        basket.addItem(basketItem2);

         int response = basket.calculateBasketPrice();

         assertTrue(response  == 4);

    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        //TODO sepette 1 urun varken sayisi arttirildiginda price hesaplanmali


        Basket basket = new Basket();
        Product elma = new Product(1,"Elma",3);
        BasketItem basketItem = new BasketItem(1,elma);
        basket.addItem(basketItem);
        basketService.incrementQuantity(elma,2);

    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        //TODO sepette 1 urun varken sayisi azaltildiginda price hesaplanmali

        Basket basket = new Basket();
        Product silah = new Product(1,"Silah",150);
        BasketItem basketItem = new BasketItem(1,silah);
        basket.addItem(basketItem);
        assertTrue(basket.calculateBasketPrice().equals(150));


    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi arttirma isleminden sonra price hesaplanmali
        Basket basket = new Basket();
        Product galate = new Product(1,"Galate",1);
        BasketItem galateItem = new BasketItem(5,galate);
        basket.addItem(galateItem);
        Product tekirdagkofte = new Product(2,"Tekirdağ Köfte",2);
        BasketItem tekirdagkofteItem = new BasketItem(18,tekirdagkofte);
        basket.addItem(tekirdagkofteItem);

      /////////
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali


        Basket basket = new Basket();

        Product erik = new Product(1,"Erik",3);
        Product elma = new Product(2,"Elma",4);
        Product armut = new Product(3,"Armut",6);
        Product patates = new Product(4,"Patates",1);

        BasketItem erikSepet = new BasketItem(25,erik);
        BasketItem elmaSepet = new BasketItem(4,elma);
        BasketItem armutSepet = new BasketItem(25,armut);
        BasketItem patatesSepet = new BasketItem(4,patates);

        basket.addItem(erikSepet);
        basket.addItem(elmaSepet);
        basket.addItem(armutSepet);
        basket.addItem(patatesSepet);
    }


}