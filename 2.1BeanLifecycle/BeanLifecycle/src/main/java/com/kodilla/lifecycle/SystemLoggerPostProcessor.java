package com.kodilla.lifecycle;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.BeanPostProcessor;
@Log4j2
public class SystemLoggerPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        log.info("create bean: "+beanName);
        return bean;
    }
}
