package com.kodilla.events.test;

public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(Throwable.class.getClassLoader());
    }
}
