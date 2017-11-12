package com.java8.test.chapter05;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamIterator01 {
    public static void main(String[] args) {
        System.out.println(" ----------------- 001 -------------- ");
        Stream.iterate(0, n -> n+2)
                .map(a -> a + " ")
                .limit(10)
                .forEach(System.out::print);

        System.out.println(" ----------------- 002 -------------- ");
        Stream.iterate(new int[] {0, 1},  t -> new int[]{t[1], t[0] + t[1]})
                .map(a -> Arrays.toString(a))
                .limit(100)
                .forEach(System.out::print);

        System.out.println(" ----------------- 003 -------------- ");
        Stream.iterate(new int[]{0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .map(t -> t[0] + " ")
                .limit(100)
                .forEach(System.out::print);

    }
}
