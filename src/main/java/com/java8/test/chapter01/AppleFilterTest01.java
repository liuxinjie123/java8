package com.java8.test.chapter01;

import com.java8.dto.Apple;
import com.java8.enu.COLOR;
import com.java8.service.impl.ApplePredicateServiceImpl;
import com.java8.service.impl.AppleRedColorPredicate;

import java.util.ArrayList;
import java.util.List;

public class AppleFilterTest01 {
    private static final Double MIN_HEAVY_WEIGHT = 150.0;

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200.0);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, MIN_HEAVY_WEIGHT+1);
        appleList.add(b);
        Apple c = new Apple("C", COLOR.YELLOW, 100.0);
        appleList.add(c);

        List<Apple> redAppleList = ApplePredicateServiceImpl.filterApples(appleList, new AppleRedColorPredicate());
        redAppleList.parallelStream().forEach(apple -> System.out.println(apple));
    }
}
