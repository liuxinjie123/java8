package com.java8.model.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trader implements Serializable {
    private String name;
    private String city;
    private int age;
}
