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
        basket.addItem(new BasketItem(1, sepet1));
        Product sepet2 = null;
        basket.addItem(new BasketItem(1, sepet2));
    }

    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        //TODO productName, quantity

        for (int i = 0; i < basket.getItems().size(); i++) {
            String productName = basket.getItems().get(i).getProduct().getName();

            Integer quantity = basket.getItems().get(i).getQuantity();

            Integer productPrice = basket.getItems().get(i).getProduct().getPrice();
            System.out.println("Ürün Adeti : " + quantity + "\nÜrün Adı : " + productName + "\nÜrün Fiyatı : " + productPrice * quantity);
        }
    }

    public void addProduct(Product product, Integer quantity) {

        basket.addItem(new BasketItem(quantity, product));


    }

    public void removeProduct(Product product) {
        //TODO ----sepetten ilgili ürünü silmel

        for (int i = 0; i < basket.getItems().size(); i++) {
            if ((basket.getItems().get(i).getProduct().equals(product))){
                basket.getItems().remove(basket.getItems().get(i));
            }
        }

    }


    public void incrementQuantity(Product product, Integer quantity) {
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali
        for (int i = 0; i < basket.getItems().size(); i++) {
            if (basket.getItems().get(i).getProduct().equals(product)) {
                Integer quantity1 = basket.getItems().get(i).getQuantity();
                BasketItem basketItem = new BasketItem(quantity1 + quantity, product);
                basket.getItems().set(i, basketItem);
            }
        }

    }

    public void decrementQuantity(Product product, Integer quantity) {
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali
        for (int i = 0; i < basket.getItems().size(); i++) {
            if (basket.getItems().get(i).getProduct().equals(product)) {
                Integer decrementQuantity = basket.getItems().get(i).getQuantity();
                BasketItem basketItem = new BasketItem(decrementQuantity - quantity, product);
                if (basketItem.getQuantity() == 0) {
                    removeProduct(product);
                } else {
                    basket.getItems().set(i, basketItem);
                }
            }
        }

    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getBasketPrice() {
        return basket.calculateBasketPrice();
    }

}
