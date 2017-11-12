package com.java8.test.chapter05;

import java.util.stream.Stream;

public class StreamGenerate01 {
    public static void main(String[] args) {
        System.out.println(" ----------------- 001 -------------- ");
        Stream.generate(Math::random)
                .limit(10)
                .map(a -> a + " ")
                .forEach(System.out::print);

        System.out.println(" ----------------- 002 -------------- ");

    }
}
