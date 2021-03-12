package com.kodilla.events.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CalculatorEvent extends ApplicationEvent {
    private String executedMethod;
    public CalculatorEvent(Object source, String executedMethod) {
        super(source);
        this.executedMethod= executedMethod;
    }
}
