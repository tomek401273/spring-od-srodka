package com.kodilla.bytecode.reflection.exercise1;

import org.apache.commons.lang3.RandomStringUtils;

public class Student {
    private String indexNumber;
    public Student() {
        indexNumber= RandomStringUtils.random(10, true, false);
    }
}
