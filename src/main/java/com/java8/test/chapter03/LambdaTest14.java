package com.java8.test.chapter03;

import com.java8.model.Apple;
import com.java8.service.functiontest.TriFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class LambdaTest14 {
    public static void main(String[] args) {
        String[] a1 = {"a", "red", "200"};
        String[] a2 = {"b", "green", "120"};
        String[] a3 = {"c", "blue", "200"};
        List<String[]> dataList = Arrays.asList(a1, a2, a3);
        List<Apple> appleList = map(dataList, Apple::new);
        appleList.stream().forEach(System.out::println);
        System.out.println(" ------------------------------------ ");
        appleList.sort(comparing(Apple::getName).reversed());
        appleList.stream().forEach(System.out::println);
        System.out.println(" ------------------------------------ ");
        appleList.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getName).reversed());
        appleList.stream().forEach(System.out::println);
        System.out.println(" ------------------------------------ ");
    }

    public static List<Apple> map(List<String[]> dataList, TriFunction<String, String, Integer, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (String[] strs : dataList) {
            result.add(function.apply(strs[0], strs[1], Integer.valueOf(strs[2])));
        }
        return result;
    }
}
