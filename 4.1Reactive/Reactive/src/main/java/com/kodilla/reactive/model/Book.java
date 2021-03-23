package com.kodilla.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
