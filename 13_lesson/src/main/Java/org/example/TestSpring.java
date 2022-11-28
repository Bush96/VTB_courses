package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");

//        ProductService productService = contex.getBean("productService", ProductService.class);
//        Cart cart = contex.getBean("cart", Cart.class);
        OrderService orderService = contex.getBean("orderService", OrderService.class);
//        productService.findByTitle("Book");
//        productService.findByTitle("Bottle");
        orderService.getOrder();
        contex.close();
    }
}
