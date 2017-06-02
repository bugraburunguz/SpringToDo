package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    @Test
    public void shouldListInitialProducts() throws Exception {
        //TODO
        final ProductService productService = new ProductService();

        assertThat(productService.getProducts().size(), Matchers.greaterThan(0));
    }

    @Test
    public void shouldAddOneProduct() throws Exception {
        //TODO
        final ProductService productService = new ProductService();

        productService.add("Top",2,3);

        assertThat(productService.getProducts().size(), Matchers.equalTo(3));



    }

    @Test
    public void shouldMultipleOneProduct() throws Exception {
        //TODO

        final ProductService productService = new ProductService();

        assertThat(productService.getProducts().size(), Matchers.greaterThan(1));
    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        //TODO
        final ProductService productService = new ProductService();

        productService.delete(2);

        assertThat(productService.getProducts().size(), Matchers.equalTo(1));




    }

    @Test
    public void shouldUpdateProductName() throws Exception {
        //TODO

        final ProductService productService = new ProductService();
        Product name = productService.updateName(2,"Karton");
        assertEquals(productService.findBy(2).getName(), "Karton");
    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        //TODO
        final ProductService productService = new ProductService();
        Product name = productService.updatePrice(2,2);
        assertTrue(productService.findBy(2).getPrice().equals(2));

    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {
        //TODO
        final ProductService productService = new ProductService();
        Product name = productService.update(2,"Karton",234);
        assertEquals(productService.findBy(2).getName(), "Karton");
        assertTrue(productService.findBy(2).getPrice().equals(234));

    }

}