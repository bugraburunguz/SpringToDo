package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()//TODO
@RestController
public class MedipolProductRestController {

    @Autowired
    private BasketService basketService;
    @Autowired
    private ProductService productService;

    //add
    @RequestMapping(path = "/addProduct")
    public Product addProduct(@RequestParam String productName, @RequestParam Integer price, @RequestParam Integer id) {
        productService.add(productName, price, id);
        return (Product) productService.getProducts();
    }

    //delete
    @RequestMapping(path = "/removeProduct")
    public Product removeProduct(@RequestParam Integer id) {
        productService.delete(id);
        return (Product) productService.getProducts();
    }

    //update
    @RequestMapping(path = "/updateProduct")
    public Product updateProduct(@RequestParam Integer id, @RequestParam String productName, @RequestParam Integer price) {

        return productService.update(id, productName, price);
    }

    //list
    @RequestMapping(path = "/listProduct")
    public Product listProduct() {
        productService.list();
        return (Product) productService.getProducts();
    }

    //findById
    @RequestMapping(path = "/findByIdProduct")
    public Product findByIdProduct(@RequestParam Integer id) {

        return productService.findBy(id);
    }

}
