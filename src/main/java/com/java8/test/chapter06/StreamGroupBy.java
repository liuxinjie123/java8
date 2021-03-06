package com.java8.test.chapter06;

import com.java8.model.Dish;
import com.java8.enu.DishType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamGroupBy {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("port", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH)
        );

        System.out.println(" ------------------ 111 -------------- ");
        Map<DishType, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getDishType));
        System.out.println(" dishesByType=" + dishesByType.toString());

        System.out.println(" ------------------ 111 -------------- ");


    }
}
