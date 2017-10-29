package com.java8.test.chapter03;

import com.java8.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaTest12 {
    public static List<Apple> map(List<Integer> integerList, Function<Integer, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : integerList) {
            result.add(function.apply(e));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(1, 11, 55, 6, 20);
        List<Apple> appleList = map(weights, Apple::new);
        appleList.parallelStream().forEach(System.out::println);
    }
}
