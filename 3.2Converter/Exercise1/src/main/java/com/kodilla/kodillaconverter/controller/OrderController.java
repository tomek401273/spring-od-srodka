package com.kodilla.kodillaconverter.controller;


import com.kodilla.kodillaconverter.model.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @PostMapping("/order")
    public void createOrder(@RequestBody Order order) {
        System.out.println("created Order: " + order);
    }
}
