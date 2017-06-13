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
    private List<Product> products = new ArrayList<Product>();
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

        for (BasketItem basketItem : basket.getItems()) {
            basketItem.getProduct().getName();
            basketItem.getQuantity();
            System.out.println(basketItem.getQuantity());
            System.out.println(basketItem.getProduct().getName());
        }

    }

    public void addProduct(Product product, Integer quantity){

    basket.addItem(new BasketItem(quantity,product));


    }

    public void removeProduct(Product product){
        //TODO ----sepetten ilgili ürünü silmel
        int basketindex = -1;
        for (int i = 0; i < basket.getItems().size(); i++) {
            if (product.getId() == products.get(i).getId()) {
                basketindex = i;
                break;
            }
        }
        products.remove(basketindex);


    }





    public void incrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali


    }

    public void decrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali


        //0 ise sepetten cikartilmali

                    removeProduct(product);

    }

    public Basket getBasket() {
        return basket;
    }


}
