package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>();

    public ProductService() {
        Product nike = new Product(1, "nike air", 200);
        products.add(nike);
        Product addidas = new Product(2, "Addidas", 300);
        products.add(addidas);

    }

    public void add(String name, Integer price ,Integer id ){
        //TODO  ---- Yapıldı

        products.add(new Product(id,name,price));
    }

    public void delete(Integer id) {
        //TODO ---- Yapıldı

        int productIndex = -1;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (id == product.getId()) {
                productIndex = i;

                break;
            }
        }
        products.remove(productIndex);
    }

    public Product update(Integer id, String name, Integer price){
        //TODO ----- Yapıldı


        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {

                products.get(i).setName(name);
                products.get(i).setPrice(price);
                return  products.get(i);

            }

        }
        return null;

    }

    public Product updateId(Integer id){
        //TODO ----- Yapıldı


        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {

                products.get(i).setId(id);

                return  products.get(i);

            }

        }
        return null;

    }

    public Product updateName(Integer id, String name){
        //TODO ----- Yapıldı


        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {


                products.get(i).setName(name);

                return  products.get(i);

            }

        }
        return null;

    }


    public Product updatePrice(Integer id, Integer price){
        //TODO ----- Yapıldı


        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {

                products.get(i).setPrice(price);
                return  products.get(i);

            }

        }
        return null;

    }


    public List<Product> list(){
        return products;
    }

    public Product findBy(int productId) {
        //TODO ---- Yapıldı

                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getId().equals(productId)) {
                        return products.get(i);
                    }

                }



        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
