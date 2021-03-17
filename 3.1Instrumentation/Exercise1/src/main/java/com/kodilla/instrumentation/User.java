package com.kodilla.instrumentation;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println("My name is "+name);
    }
}
