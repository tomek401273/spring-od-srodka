package com.kodilla.events.controller;

import com.kodilla.events.event.CalculatorEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/v1/")
public class CalculatorController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher){
        this.applicationEventPublisher=applicationEventPublisher;
    }

    @RequestMapping("/add")
    public BigDecimal add(@RequestParam BigDecimal numberOne, @RequestParam BigDecimal numberTwo){
        BigDecimal result= numberOne.add(numberTwo);
        applicationEventPublisher.publishEvent(new CalculatorEvent(this, "add"));
        return result;
    }

    @RequestMapping("/subtract")
    public BigDecimal subtract(@RequestParam BigDecimal numberOne, @RequestParam BigDecimal numberTwo){
        BigDecimal result= numberOne.subtract(numberTwo);
        applicationEventPublisher.publishEvent(new CalculatorEvent(this, "subtract"));
        return result;
    }

    @RequestMapping("/multiply")
    public BigDecimal multiply (@RequestParam BigDecimal numberOne, @RequestParam BigDecimal numberTwo){
        BigDecimal result= numberOne.multiply(numberTwo);
        applicationEventPublisher.publishEvent(new CalculatorEvent(this, "multiply"));
        return result;
    }

    @RequestMapping("/divide")
    public BigDecimal divide(@RequestParam BigDecimal numberOne, @RequestParam BigDecimal numberTwo){
        BigDecimal result= numberOne.divide(numberTwo,2, RoundingMode.HALF_UP);
        applicationEventPublisher.publishEvent(new CalculatorEvent(this, "divide"));
        return result;
    }

}
