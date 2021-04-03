package com.java8.model;

import com.java8.enu.COLOR;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Apple implements Serializable {
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    private String name;
    private String color;
    private Integer weight;

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Apple(String name, String color, Integer weight) {
        this(name, color);
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return COLOR.GREEN.equals(apple.getColor());
    }

    public static boolean isRedApple(Apple apple) {
        return COLOR.RED.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return MIN_HEAVY_WEIGHT < apple.getWeight();
    }

}
