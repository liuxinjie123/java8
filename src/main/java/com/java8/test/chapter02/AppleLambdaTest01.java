package com.java8.test.chapter02;

import com.java8.model.Apple;
import com.java8.enu.COLOR;
import com.java8.predicate.apple.ApplePredicate;
import com.java8.predicate.common.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class AppleLambdaTest01 {

    public void execute() {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, 151);
        appleList.add(b);
        Apple c = new Apple("C", COLOR.YELLOW, 100);
        appleList.add(c);

        List<Apple> greenAppleList = appleList.parallelStream().filter(apple -> COLOR.GREEN.equals(apple.getColor())).collect(toList());
        greenAppleList.parallelStream().forEach(apple -> System.out.println(apple.toString()));

        System.out.println(" --------------------------------------------- ");

        greenAppleList = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return COLOR.GREEN.equals(apple.getColor());
            }
        });

        greenAppleList.parallelStream().forEach(apple -> System.out.println(apple));

        System.out.println(" --------------------------------------------- ");

        appleList.sort((Apple a1, Apple a2) -> a2.getName().compareTo(a1.getName()));
        appleList.stream().forEach(apple -> System.out.println(apple));

        System.out.println(" --------------------------------------------- ");
        appleList.sort(comparing(Apple::getName));
        appleList.stream().forEach(apple -> System.out.println(apple));

        System.out.println(" --------------------------------------------- ");

        List<Integer> numList = Arrays.asList(1, 3, 22, 3, 100);
        numList.parallelStream().forEach(i -> System.out.println(i));

        System.out.println(" --------------------------------------------- ");

        numList = Predicate.filter(numList, (Integer i) -> i >  2);
        numList.parallelStream().forEach(i -> System.out.println(i));


    }

    List<Apple> filterApples(List<Apple> appleList, ApplePredicate p) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }



    public static void main(String[] args) {
        AppleLambdaTest01 test = new AppleLambdaTest01();
        test.execute();
    }
}
