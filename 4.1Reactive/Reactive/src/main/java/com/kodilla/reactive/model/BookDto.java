package com.kodilla.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BookDto {
    private final String title;
    private final String author;
    private final int year;
}
