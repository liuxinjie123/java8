package com.java8.test.chapter03;

import com.java8.model.Apple;
import com.java8.service.applePredicate.ApplePredicate;
import com.java8.service.applePredicate.impl.AppleGreenColorPredicate;
import com.java8.service.applePredicate.impl.AppleHeavyWeightPredicate;
import com.java8.service.applePredicate.impl.AppleRedColorPredicate;
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

        System.out.println(" 111 create list ------------------------------------ ");
        List<String[]> dataList = Arrays.asList(a1, a2, a3);
        List<Apple> appleList = map(dataList, Apple::new);
        appleList.stream().forEach(System.out::println);

        System.out.println(" 222 sorted list reversed ------------------------------------ ");
        appleList.sort(comparing(Apple::getName).reversed());
        appleList.stream().forEach(System.out::println);

        System.out.println(" 333 sorted list then ------------------------------------ ");
        appleList.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getName).reversed());
        appleList.stream().forEach(System.out::println);

        System.out.println(" 444 green ones ------------------------------------ ");
        List<Apple> greenAppleList = filterApples(appleList, new AppleGreenColorPredicate());
        greenAppleList.stream().forEach(System.out::println);

        System.out.println(" 555 red ones ------------------------------------ ");
        List<Apple> redAppleList = filterApples(appleList, new AppleRedColorPredicate());
        redAppleList.stream().forEach(System.out::println);

        System.out.println(" 666 not red ones ------------------------------------ ");
        List<Apple> notRedAppleList = negateApples(appleList, new AppleRedColorPredicate());
        notRedAppleList.stream().forEach(System.out::println);

        System.out.println(" 777 not green ones ------------------------------------ ");
        List<Apple> notGreenAppleList = negateApples(appleList, new AppleGreenColorPredicate());
        notGreenAppleList.stream().forEach(System.out::println);

        System.out.println(" 888 not heavy ones ------------------------------------ ");
        List<Apple> notHeavyAppleList = negateApples(appleList, new AppleHeavyWeightPredicate());
        notHeavyAppleList.stream().forEach(System.out::println);

        System.out.println(" 999 not red ones ------------------------------------ ");
        ApplePredicate notReaApplePredicate = new AppleRedColorPredicate().negate();
        List<Apple> notRedAppleList2 = filterApples(appleList, notReaApplePredicate);
        notRedAppleList2.stream().forEach(System.out::println);

        System.out.println(" 101010 red and green ones --------------------------------- ");
        ApplePredicate redAndGreenApplePredicate = new AppleRedColorPredicate().and(new AppleGreenColorPredicate());
        List<Apple> redAndGreenAppleList = filterApples(appleList, redAndGreenApplePredicate);
        redAndGreenAppleList.stream().forEach(System.out::println);

        System.out.println(" 111111 red and heavy ones --------------------------------- ");
        ApplePredicate redAndHeavyApplePredicate = new AppleRedColorPredicate().and(new AppleHeavyWeightPredicate());
        List<Apple> redAndHeavyAppleList = filterApples(appleList, redAndHeavyApplePredicate);
        redAndHeavyAppleList.stream().forEach(System.out::println);

        System.out.println(" 121212 red and not heavy ones --------------------------------- ");
        ApplePredicate redAndNotHeavyApplePredicate = new AppleRedColorPredicate().and(new AppleHeavyWeightPredicate().negate());
        List<Apple> redAndNotHeavyAppleList = filterApples(appleList, redAndNotHeavyApplePredicate);
        redAndNotHeavyAppleList.stream().forEach(System.out::println);

        System.out.println(" 131313 green and not heavy ones --------------------------------- ");
        ApplePredicate greenAndNotHeavyApplePredicate = new AppleGreenColorPredicate().and(new AppleHeavyWeightPredicate().negate());
        List<Apple> greenAndNotHeavyAppleList = filterApples(appleList, greenAndNotHeavyApplePredicate);
        greenAndNotHeavyAppleList.stream().forEach(System.out::println);

        System.out.println(" 141414 red or green ones --------------------------------- ");
        ApplePredicate redOrGreenApplePredicate = new AppleRedColorPredicate().or(new AppleGreenColorPredicate());
        List<Apple> redOrGreenAppleList = filterApples(appleList, redOrGreenApplePredicate);
        redOrGreenAppleList.stream().forEach(System.out::println);
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

    public static List<Apple> negateApples(List<Apple> list, ApplePredicate function) {
        List<Apple> result = new ArrayList<>();
        ApplePredicate negateFunction = function.negate();
        for (Apple apple : list) {
            if (negateFunction.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
