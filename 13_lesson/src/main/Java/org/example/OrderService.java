package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    private Cart cart;


    private List<Product> orderList;

    @Autowired
    public OrderService(Cart cart, List<Product> orderList) {
        this.cart = cart;
        this.orderList = orderList;
    }

    public void getOrder() {
        orderList.remove(0);
        orderList.add(cart.addItems("Book"));
        orderList.add(cart.addItems("Bottle"));
        orderList.add(cart.addItems("Phone"));
        int sum =orderList.stream().mapToInt(Product::getCost).sum();

        System.out.println("В вашей корзине находится: " + orderList + "Общей стоимостью " + sum);
    }
}
