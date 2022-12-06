package com.example.demo2.repositories;

import com.example.demo2.models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Bread", 40));
        products.add(new Product(2, "Milk", 90));
        products.add(new Product(3, "Cheese", 200));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public void save(Product product) {
        products.add(product);
    }

    public void update(Product product, int id) {
        products.set(id - 1, product);
    }

    public List<Product> search(String query) {
        return products.stream().filter(p -> p.getTitle().equals(query)).toList();
    }

    public List<Product> searchWithPrice(Integer query1, Integer query2) {

        return products.stream().filter(p ->p.getPrice()>=query1&p.getPrice()<=query2).toList();                     //тут последнее с чем надо поебстись
    }
}








