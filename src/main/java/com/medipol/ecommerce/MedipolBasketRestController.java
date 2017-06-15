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
public class MedipolBasketRestController {

    @Autowired
    private BasketService basketService;
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/addToBasket")
    public Basket addToBasket(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product, quantity);
        return basketService.getBasket();

    }

    //createBasket
    @RequestMapping(path = "/createBasket")
    public Basket createBasket() {

        basketService.createBasket();
        return basketService.getBasket();

    }

    //getBasketDetail
    @RequestMapping(path = "/getBasketDetail")
    public Basket getBasketDetail(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product, quantity);
        return basketService.getBasket();

    }

    //removeProduct

    @RequestMapping(path = "/removeProduct")
    public Basket removeProduct(@RequestParam Product productId) {
        basketService.removeProduct(productId);
        return basketService.getBasket();
    }

    //incrementQuantity
    @RequestMapping(path = "/incrementQuantity")
    public Basket incrementQuantity(@RequestParam Product productId, @RequestParam int quantity) {
        basketService.incrementQuantity(productId, quantity);
        return basketService.getBasket();
    }

    //decrementQuantity
    @RequestMapping(path = "/decrementQuantity")
    public Basket decrementQuantity(@RequestParam Product productId, @RequestParam int quantity) {

        basketService.decrementQuantity(productId, quantity);
        return basketService.getBasket();
    }

    //getBasketPrice
    @RequestMapping(path = "/getBasketPrice")
    public Basket getBasketPrice() {
        basketService.printBasketDetail();
        return basketService.getBasket();
    }

}
