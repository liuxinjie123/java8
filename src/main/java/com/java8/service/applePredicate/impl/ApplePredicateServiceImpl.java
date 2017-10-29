package com.java8.service.applePredicate.impl;

import com.java8.model.Apple;
import com.java8.service.applePredicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class ApplePredicateServiceImpl {
    public static List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }
}
