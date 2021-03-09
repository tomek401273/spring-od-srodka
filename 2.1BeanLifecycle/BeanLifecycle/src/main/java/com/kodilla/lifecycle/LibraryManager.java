package com.kodilla.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LibraryManager implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public void setBeanName(String beanName) {
        this.name = beanName;
        System.out.println("Name of the bean: " + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader instance passed: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory instance passed " + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void exmpleConstructMethod() {
        System.out.println("Method with @PostConstruct annotaion");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Method destroy has been called");
    }

    @PreDestroy
    public void exampleDestroyMethod() {
        System.out.println("Methdod with @PreDestroy annotation");
    }

}
