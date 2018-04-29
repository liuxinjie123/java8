package com.java8.model;

import com.java8.enu.COLOR;
import com.java8.test.chapter01.FilterApplesTest;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Apple implements Serializable {
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
        return COLOR.GREEN.equals(apple.getColor());
    }

    public static boolean isRedApple(Apple apple) {
        return COLOR.RED.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return MIN_HEAVY_WEIGHT < apple.getWeight();
    }

}
