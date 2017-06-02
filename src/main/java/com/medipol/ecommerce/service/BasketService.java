package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    private Basket basket = new Basket();

    public BasketService() {
        Product sepet1 = null;
        basket.addItem(new BasketItem(1,sepet1));
        Product sepet2 = null;
        basket.addItem(new BasketItem(1,sepet2));
    }
    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        //TODO productName, quantity
    }

    public void addProduct(Product product, Integer quantity){
        //TODO

    basket.addItem(new BasketItem(quantity,product));


    }

    public void removeProduct(Product product){
        //TODO ----sepetten ilgili ürünü silmeli


    }

    public void incrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali
    }

    public void decrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali
    }

    public Basket getBasket() {
        return basket;
    }


}
