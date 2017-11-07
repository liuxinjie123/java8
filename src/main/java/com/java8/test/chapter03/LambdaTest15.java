package com.java8.test.chapter03;

import java.util.function.Function;

public class LambdaTest15 {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> k = f.compose(g);

        int res1 = h.apply(2);
        System.out.println("res1=" + res1);
        int res2 = k.apply(2);
        System.out.println("res2=" + res2);
    }
}
