package com.kodilla.events.service;

import com.kodilla.events.event.ProductRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductImageManager implements ApplicationListener<ProductRegisteredEvent> {
    public void onApplicationEvent(ProductRegisteredEvent productRegisteredEvent){
        System.out.println("Procesing immage of "+productRegisteredEvent.getProductName());
        System.out.println("The graphics is: "+productRegisteredEvent.getOtherData());
    }
}
