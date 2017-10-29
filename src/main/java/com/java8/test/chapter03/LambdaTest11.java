package com.java8.test.chapter03;

import com.java8.model.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest11 {
    public static void main(String[] args) {
        Runnable runnable = () -> {System.out.println("Hello World!");};
        runnable.run();
        String hello = "Hello Lambda!";
        List<String> list = Arrays.asList("a", "b", "A", "B");
        list.sort(String::compareToIgnoreCase);
        list.stream().forEach(System.out::println);

        Function<String, Integer> stringToInteger = Integer::parseInt;
        int parseNum = stringToInteger.apply("111");
        System.out.println("parseNum=" + parseNum);

        List<String> list2 = Arrays.asList("a", "b", "Hello", "jack", "love");

        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
        Apple a2 = new Apple();
        Function<Integer, Apple> c2 = Apple::new;
        Apple a3 = c2.apply(100);
        System.out.println("a1=" + a1.toString());
        System.out.println("a2=" + a2.toString());
        System.out.println("a3=" + a3.toString());

    }
}
