package com.java8.model.bank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Trader implements Serializable {
    private String name;
    private String city;
    private int age;

    public Trader(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }
}
