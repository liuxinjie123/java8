package com.java8.test.chapter05;

import java.util.stream.IntStream;

public class StreamTest02 {
    public static void main(String[] args) {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);
        System.out.println(" count=" + evenNumbers.count());



    }
}
