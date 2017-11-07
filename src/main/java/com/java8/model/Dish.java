package com.java8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish implements Serializable {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;
}
