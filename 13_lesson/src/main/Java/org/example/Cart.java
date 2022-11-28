package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cart {

    private ProductService productService;

    private List<Product> theCart;

    @Autowired
    public Cart(ProductService productService, List<Product> theCart) {
        this.productService = productService;
        this.theCart = theCart;
    }

    public Product addItems(String title) {
        Product product = productService.findByTitle(title);

        return product;
    }


}
