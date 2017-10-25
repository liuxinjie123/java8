package com.java8.test.chapter03;

import java.util.Arrays;
import java.util.List;

public class LambdaTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "B", "E", "x", "Y", "z");
        list.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        list.stream().forEach(System.out::println);
        System.out.println(" --------------------------------- ");
        List<String> list2 = Arrays.asList("a", "B", "E", "x", "Y", "z");
        list2.sort(String::compareToIgnoreCase);
        list2.stream().forEach(System.out::println);
    }
}
