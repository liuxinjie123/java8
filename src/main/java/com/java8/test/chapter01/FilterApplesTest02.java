package com.java8.test.chapter01;

import com.java8.dto.Apple;
import com.java8.enu.COLOR;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class FilterApplesTest02 {
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200.0);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, MIN_HEAVY_WEIGHT+1);
        appleList.add(b);
        appleList.stream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println("\n---------------------------------\n");
        appleList.sort(comparing(Apple::getWeight));
        appleList.stream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println("\n---------------------------------\n");
        List<Apple> heavyAppleList = appleList.stream().filter(apple -> apple.getWeight() > 150).collect(toList());
        heavyAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
        System.out.println("\n---------------------------------\n");
        List<Apple> greenAppleList = appleList.parallelStream().filter(apple -> apple.getColor().equals(COLOR.GREEN)).collect(toList());
        greenAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));
    }
}
