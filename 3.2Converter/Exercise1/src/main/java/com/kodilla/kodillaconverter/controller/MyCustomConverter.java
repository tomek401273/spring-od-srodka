package com.kodilla.kodillaconverter.controller;

import com.kodilla.kodillaconverter.model.Order;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MyCustomConverter implements HttpMessageConverter<Object> {
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.kodilla.kodillaconverter.model.Order") &&
                mediaType.getType().equals("thomson") && mediaType.getSubtype().equals("simple");
    }

    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.kodilla.kodillaconverter.model.Order") &&
                mediaType.getType().equals("thomson") && mediaType.getSubtype().equals("simple");
    }

    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.ALL);
    }

    public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Scanner scanner = new Scanner(inputMessage.getBody()).useDelimiter(";");
        return new Order(Integer.valueOf(scanner.next()), scanner.next(), Double.valueOf(scanner.next()));
    }
    // example body
    // 10;order19;1.5;
    public void write(Object o, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws HttpMessageNotWritableException {
    }
}
