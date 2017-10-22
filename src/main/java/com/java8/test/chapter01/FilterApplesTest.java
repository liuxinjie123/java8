package com.java8.test.chapter01;

import com.java8.dto.Apple;

import java.util.ArrayList;
import java.util.List;

public class FilterApplesTest {
    private static final String COLOR_GREEN = "green";
    private static final String COLOR_RED = "red";
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    public static boolean isGreenApple(Apple apple) {
        return COLOR_GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return MIN_HEAVY_WEIGHT < apple.getWeight();
    }

    public interface Predicate<T> {
        boolean compare(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.compare(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR_GREEN, 100.0);
        appleList.add(a);
        Apple b = new Apple("B", COLOR_RED, MIN_HEAVY_WEIGHT+1);
        appleList.add(b);
        appleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println(" ----------------------------------------- ");
        List<Apple> greenAppleList = filterApples(appleList, Apple::isGreenApple);
        greenAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println(" ----------------------------------------- ");
        List<Apple> heavyAppleList = filterApples(appleList, Apple::isHeavyApple);
        heavyAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
    }

}
