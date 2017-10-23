package com.java8.test.chapter01;

import com.java8.dto.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class FilterApplesTest02 {
    private static final String COLOR_GREEN = "green";
    private static final String COLOR_RED = "red";
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR_GREEN, 200.0);
        appleList.add(a);
        Apple b = new Apple("B", COLOR_RED, MIN_HEAVY_WEIGHT+1);
        appleList.add(b);
        appleList.stream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println("\n---------------------------------\n");
        appleList.sort(comparing(Apple::getWeight));
        appleList.stream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println("\n---------------------------------\n");
        List<Apple> heavyAppleList = appleList.stream().filter(apple -> apple.getWeight() > 150).collect(toList());
        heavyAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println("\n---------------------------------\n");
        List<Apple> greenAppleList = appleList.parallelStream().filter(apple -> apple.getColor().equals(COLOR_GREEN)).collect(toList());
        greenAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
    }
}
