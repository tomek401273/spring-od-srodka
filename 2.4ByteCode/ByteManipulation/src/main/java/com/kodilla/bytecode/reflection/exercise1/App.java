package com.kodilla.bytecode.reflection.exercise1;

import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student =new Student();
        Class<Student> studentClass= Student.class;
        Field indexNumberField = studentClass.getDeclaredField("indexNumber");
        indexNumberField.setAccessible(true);
        System.out.println(indexNumberField.get(student));
    }
}
