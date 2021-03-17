package com.kodilla.kodillaconverter.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable {
    private Integer id;
    private String name;
    private Double amount;
}
