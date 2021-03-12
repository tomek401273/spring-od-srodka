package com.kodilla.events.service;

import com.kodilla.events.event.CalculatorEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CalculatorEventListener implements ApplicationListener<CalculatorEvent> {
    public void onApplicationEvent(CalculatorEvent calculatorEvent){
       log.info("operation: "+calculatorEvent.getExecutedMethod());
    }

}
