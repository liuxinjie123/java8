package com.java8.test.chapter05;

import java.util.Arrays;
import java.util.List;

public class StreamDistinct {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 3, 5, 9, 1, 3, 99, 8, 88, 0, 33, 3);
        numList.parallelStream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" ----------------- 111 ----------------- ");

        numList.parallelStream()
                .filter(i -> i % 2 == 1)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" ----------------- 222 ----------------- ");

        numList.parallelStream()
                .filter(i -> i % 3 == 0)
                .forEach(System.out::println);

        System.out.println(" ----------------- 333 ----------------- ");

        numList.parallelStream()
                .filter(i -> i % 3 == 0)
                .limit(3)
                .forEach(System.out::println);

        System.out.println(" ----------------- 444 ----------------- ");

        numList.parallelStream()
                .filter(i -> i % 3 ==0)
                .distinct()
                .limit(3)
                .forEach(System.out::println);

        System.out.println(" ----------------- 555 ----------------- ");

        numList.stream()
                .filter(i -> i % 2 == 1)
                .distinct()
                .sorted(Integer::compareTo)
                .forEach(System.out::println);

        System.out.println(" ----------------- 666 ----------------- ");

        numList.stream()
                .filter(i -> i % 2 == 1)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" ----------------- 777 ---------------- ");

        numList.stream()
                .filter(i -> i % 2 == 1)
                .distinct()
                .skip(2)
                .forEach(System.out::println);
    }
}
