package com.example.demo2.controllers;

import com.example.demo2.models.Product;
import com.example.demo2.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showProductsList(Model model) {
        Product product = new Product();
        model.addAttribute("products", productsService.getAllProducts());
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        productsService.add(product);
        return "redirect:/products";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute(value = "product")Product product, @PathVariable("id") int id) {
        productsService.editProduct(product, id);
        return "redirect:/products";

    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable(value = "id") int id) {
        Product product =productsService.getById(id);
        model.addAttribute("product", product);
//        productsService.getById(product1);
        return "edit-page";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") int id) {
        Product product = productsService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }

    @GetMapping("/search")
    public String search() {
        return "search-page";
    }

    @PostMapping("/search")
    public String findProduct( Model model, @RequestParam("query") String query) {

        model.addAttribute("products",productsService.searchByTitle(query));
        return "search-page";
    }

    @PostMapping("/searchWithPrice")
    public String findProductWithPrice( Model model, @RequestParam("query1") Integer query1,
                                        @RequestParam("query2") Integer query2) {

        model.addAttribute("products",productsService.searchWithPrice(query1, query2));
        return "search-page";
    }
}
