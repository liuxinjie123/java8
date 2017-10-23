package com.java8.test.chapter02;

import com.java8.dto.Apple;
import com.java8.enu.COLOR;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AppleLambdaTest01 {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200.0);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, 151.0);
        appleList.add(b);
        Apple c = new Apple("C", COLOR.YELLOW, 100.0);
        appleList.add(c);

        List<Apple> greenAppleList = appleList.parallelStream().filter(apple -> COLOR.GREEN.equals(apple.getColor())).collect(toList());
        greenAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));

        System.out.println(" --------------------------------------------- ");

        appleList.sort((Apple a1, Apple a2) -> a2.getName().compareTo(a1.getName()));
        appleList.stream().forEach(apple -> System.out.println(apple));
    }
}
