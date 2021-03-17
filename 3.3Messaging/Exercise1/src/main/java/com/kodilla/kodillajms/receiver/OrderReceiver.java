package com.kodilla.kodillajms.receiver;

import com.kodilla.kodillajms.model.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "destination-order")
    public void receive(Order order){
        System.out.println("received Order:"+ order);
    }
}
