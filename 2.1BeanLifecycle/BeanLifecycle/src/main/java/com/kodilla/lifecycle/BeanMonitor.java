package com.kodilla.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanMonitor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        System.out.println("Before initialization of bean: "+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("After initialization of bean: "+beanName);
        return bean;
    }
}
