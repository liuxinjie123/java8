package com.java8.test.chapter03;

import java.util.function.Predicate;

public class LambdaTest08 {
    public interface IntPredicate {
        boolean test(int t);
    }


    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        oddNumbers.test(1000);
    }
}
