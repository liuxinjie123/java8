package com.java8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple implements Serializable {
    private static final String COLOR_GREEN = "green";
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    private String name;
    private String color;
    private Double weight;

    public static boolean isGreenApple(Apple apple) {
        return COLOR_GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return MIN_HEAVY_WEIGHT < apple.getWeight();
    }
}
