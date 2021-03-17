package com.kodilla.kodillaconverter.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfiguration {
    @Bean
    MyCustomConverter myCustomConverter(){
        return new MyCustomConverter();
    }
}
