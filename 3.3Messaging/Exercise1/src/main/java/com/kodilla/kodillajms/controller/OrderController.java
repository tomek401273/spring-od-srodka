package com.kodilla.kodillajms.controller;

import com.kodilla.kodillajms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/order")
    public void createOrder(@RequestBody Order order) {
        System.out.println("created Order: " + order);
        jmsTemplate.convertAndSend("destination-order", order);
    }
}
