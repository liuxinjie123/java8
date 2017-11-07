package com.java8.test.chapter04;

import com.java8.model.Apple;
import com.java8.service.functiontest.TriFunction;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class LambdaTest0401 {
    public static void main(String[] args) {
        String[] data1 = {"a", "red", "120"};
        String[] data2 = {"b", "green", "100"};
        String[] data3 = {"c", "blue", "200"};
        List<String[]> dataList = Arrays.asList(data1, data2, data3);
        List<Apple> appleList = map(dataList, Apple::new);
        appleList.parallelStream().forEach(System.out::println);
        List<String> notHeavyApplesName = appleList.parallelStream()
                .filter(apple -> apple.getWeight() < 150)
                .sorted(comparing(Apple::getName))
                .map(Apple::getName)
                .collect(toList());
        notHeavyApplesName.parallelStream().forEach(System.out::println);
    }

    public static List<Apple> map(List<String[]> dataList, TriFunction<String, String, Integer, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (String[] data : dataList) {
            result.add(function.apply(data[0], data[1], Integer.valueOf(data[2])));
        }
        return result;
    }
}
