package com.medipol.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> items = new ArrayList<>();

    public void addItem(BasketItem item) {
        items.add(item);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public Integer calculateBasketPrice() {
        //TODO
        Integer calculatebasket = 0;
        for (int i = 0; i < items.size(); i++) {

            calculatebasket += items.get(i).price();

        }

        return calculatebasket;
    }
}
