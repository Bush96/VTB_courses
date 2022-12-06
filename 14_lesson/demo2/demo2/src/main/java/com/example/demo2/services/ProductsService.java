package com.example.demo2.services;

import com.example.demo2.models.Product;
import com.example.demo2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductRepository productRepository;


    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public void editProduct(Product updatedProduct, int id) {
       productRepository.update(updatedProduct, id);

    }

    public List<Product> searchByTitle(String query) {
        return productRepository.search(query);
    }

    public List<Product> searchWithPrice(Integer query1, Integer query2) {
        return productRepository.searchWithPrice(query1, query2);
    }
}
