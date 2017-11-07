package com.java8.test.chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class StreamDistinct {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 3, 5, 9, 1, 3, 99, 8, 88, 0, 33, 3);
        numList.parallelStream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" ---------------------------------- ");

        numList.parallelStream()
                .filter(i -> i % 2 == 1)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" ---------------------------------- ");

        numList.parallelStream()
                .filter(i -> i % 3 == 0)
                .forEach(System.out::println);

        System.out.println(" ---------------------------------- ");

        numList.parallelStream()
                .filter(i -> i % 3 == 0)
                .limit(3)
                .forEach(System.out::println);

        System.out.println(" ---------------------------------- ");

        numList.parallelStream()
                .filter(i -> i % 3 ==0)
                .distinct()
                .limit(3)
                .forEach(System.out::println);

        System.out.println(" ---------------------------------- ");

        numList.stream()
                .filter(i -> i % 2 == 1)
                .distinct()
                .sorted(Integer::compareTo)
                .forEach(System.out::println);
    }
}
