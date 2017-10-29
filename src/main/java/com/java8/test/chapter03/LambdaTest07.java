package com.java8.test.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaTest07 {
//    @FunctionalInterface
//    public interface Function<T, R> {
//        R apply(T t);
//    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = map(
                Arrays.asList("Hello", "lambda", "java", "Welcome to Shanghai", "wow"),
                (String s) -> s.length()
        );
        list.parallelStream().forEach(integer -> System.out.println(integer));
        System.out.println(" -------------------------------- ");
        list.stream().forEach(System.out::println);
    }
}
