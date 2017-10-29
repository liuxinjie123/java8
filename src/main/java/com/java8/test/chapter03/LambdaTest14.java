package com.java8.test.chapter03;

import com.java8.model.Apple;
import com.java8.service.applePredicate.ApplePredicate;
import com.java8.service.applePredicate.impl.AppleGreenColorPredicate;
import com.java8.service.applePredicate.impl.AppleHeavyWeightPredicate;
import com.java8.service.applePredicate.impl.AppleRedColorPredicate;
import com.java8.service.functiontest.TriFunction;
import com.java8.test.chapter01.FilterApplesTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class LambdaTest14 {
    public static void main(String[] args) {
        String[] a1 = {"a", "red", "200"};
        String[] a2 = {"b", "green", "120"};
        String[] a3 = {"c", "blue", "200"};
        System.out.println(" 111 ------------------------------------ ");
        List<String[]> dataList = Arrays.asList(a1, a2, a3);
        List<Apple> appleList = map(dataList, Apple::new);
        appleList.stream().forEach(System.out::println);
        System.out.println(" 222 ------------------------------------ ");
        appleList.sort(comparing(Apple::getName).reversed());
        appleList.stream().forEach(System.out::println);
        System.out.println(" 333 ------------------------------------ ");
        appleList.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getName).reversed());
        appleList.stream().forEach(System.out::println);
        System.out.println(" 444 ------------------------------------ ");
        List<Apple> greenAppleList = filterApples(appleList, new AppleGreenColorPredicate());
        greenAppleList.stream().forEach(System.out::println);
        System.out.println(" 555 ------------------------------------ ");
        List<Apple> redAppleList = filterApples(appleList, new AppleRedColorPredicate());
        redAppleList.stream().forEach(System.out::println);
        System.out.println(" 666 ------------------------------------ ");
        List<Apple> notRedAppleList = negateApples(appleList, new AppleRedColorPredicate());
        notRedAppleList.stream().forEach(System.out::println);
        System.out.println(" 777 ------------------------------------ ");
        List<Apple> notGreenAppleList = negateApples(appleList, new AppleGreenColorPredicate());
        notGreenAppleList.stream().forEach(System.out::println);
        System.out.println(" 888 ------------------------------------ ");
        List<Apple> notHeavyAppleList = negateApples(appleList, new AppleHeavyWeightPredicate());
        notHeavyAppleList.stream().forEach(System.out::println);
        System.out.println(" 999 ------------------------------------ ");

    }

    public static List<Apple> map(List<String[]> dataList, TriFunction<String, String, Integer, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (String[] strs : dataList) {
            result.add(function.apply(strs[0], strs[1], Integer.valueOf(strs[2])));
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> list, ApplePredicate function) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (function.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> negateApples(List<Apple> list, Predicate function) {
        List<Apple> result = new ArrayList<>();
        Predicate<Apple> negateFunction = function.negate();
        for (Apple apple : list) {
            if (negateFunction.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
