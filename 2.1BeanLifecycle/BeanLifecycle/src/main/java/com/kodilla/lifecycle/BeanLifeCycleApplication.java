package com.kodilla.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BeanLifeCycleApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfiguration.class);
        applicationContext.refresh();

        LibraryManager manager= applicationContext.getBean(LibraryManager.class);
        System.out.println("Context and beans are set and ready to work");
        applicationContext.close();

    }
}
