package com.java8.test.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest05 {
//    @FunctionalInterface
//    public interface Predicate<T> {
//        boolean test(T t);
//    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

        List<String> list = Arrays.asList("aaa", "", "Hello", "We will get there.", "Welcome to Shanghai.", "Give me some sunshine.");
        list.parallelStream().forEach(s -> System.out.println(s));

        System.out.println(" ------------------------------------ ");

        List<String> nonEmptyList = filter(list, nonEmptyStringPredicate);
        nonEmptyList.parallelStream().forEach(s -> System.out.println(s));

    }
}
