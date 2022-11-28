package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class ProductService {

    private List<Product> productsList;


    @Autowired
    public ProductService(List<Product> productsList) {
        this.productsList = productsList;
    }

    @PostConstruct
    public List<Product> productList() {
        this.productsList.add(new Product(1, "Book", 20));
        this.productsList.add(new Product(2, "Bottle", 2));
        this.productsList.add(new Product(3, "Phone", 1000));
        this.productsList.remove(0);
        return productsList;
    }

    public void findAll() {
        System.out.println(productsList);
    }

    public Product findByTitle(String title) {
        Product finded = productsList.stream().filter(product -> (product.getTitle() == title))
                .findFirst().orElse(null);

        return finded;
    }
}
