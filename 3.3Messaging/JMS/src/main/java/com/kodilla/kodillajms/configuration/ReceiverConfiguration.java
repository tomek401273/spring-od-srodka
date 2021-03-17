package com.kodilla.kodillajms.configuration;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
@Configuration
public class ReceiverConfiguration {
    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer defaultJmsListenerContainerFactoryConfigurer
    ){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory= new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactoryConfigurer.configure(defaultJmsListenerContainerFactory, connectionFactory);
        return defaultJmsListenerContainerFactory;
    }
}
