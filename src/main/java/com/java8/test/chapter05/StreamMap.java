package com.java8.test.chapter05;

import java.util.Arrays;
import java.util.List;

public class StreamMap {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "Hello", "jack", "lxj", "Come on", "I love you", "We will get there");

        strList.parallelStream()
                .forEach(System.out::println);

        System.out.println(" ----------------- 111 ---------------- ");

        strList.parallelStream()
                .map(String::length)
                .forEach(System.out::println);

        System.out.println(" ----------------- 222 ---------------- ");

        strList.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println(" ----------------- 333 ---------------- ");

        strList.stream()
                .map(String::length)
                .map(i -> i*i)
                .forEach(System.out::println);




    }
}
