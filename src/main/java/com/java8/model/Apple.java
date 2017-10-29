package com.java8.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Apple implements Serializable {
    private static final String COLOR_GREEN = "green";
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    private String name;
    private String color;
    @NonNull
    private Integer weight;

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public static boolean isGreenApple(Apple apple) {
        return COLOR_GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return MIN_HEAVY_WEIGHT < apple.getWeight();
    }
}
