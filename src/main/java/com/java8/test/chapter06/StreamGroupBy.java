package com.java8.test.chapter06;

import com.java8.model.Dish;
import com.java8.model.Type;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamGroupBy {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("port", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH)
        );

        System.out.println(" ------------------ 111 -------------- ");
        Map<Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(" dishesByType=" + dishesByType.toString());

        System.out.println(" ------------------ 111 -------------- ");


    }
}
