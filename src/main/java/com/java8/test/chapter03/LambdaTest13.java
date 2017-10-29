package com.java8.test.chapter03;

import com.java8.model.Apple;

import java.util.*;
import java.util.function.BiFunction;

public class LambdaTest13 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "red");
        map.put("b", "green");
        map.put("c", "blue");
        List<Apple> appleList = map(map, Apple::new);
        appleList.parallelStream().forEach(System.out::println);
    }

    public static List<Apple> map(Map<String, String> data, BiFunction<String, String, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (String key : data.keySet()) {
            result.add(function.apply(key, data.get(key)));
        }
        return result;
    }
}
