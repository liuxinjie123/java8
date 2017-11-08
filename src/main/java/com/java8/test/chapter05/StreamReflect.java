package com.java8.test.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class StreamReflect {
    public static void main(String[] args) {
        List<Integer> numberList1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numberList2 = Arrays.asList(3, 4);
        List<int[]> pairs = numberList1.stream()
                .flatMap(i -> numberList2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        pairs.stream().forEach(a -> System.out.println(a[0] + " --- " + a[1]));

        System.out.println(" ----------------- 111 ------------------ ");

        pairs = numberList1.stream()
                .flatMap(i -> numberList2.stream()
                        .filter(j -> (i + j) % 2 == 0)
                        .map(j -> new int[]{i, j})
                ).collect(toList());
        pairs.stream().forEach(a -> System.out.println(a[0] + " --- " + a[1]));

        System.out.println(" ----------------- 222 ------------------ ");

        if (numberList1.parallelStream()
                .anyMatch(i -> (i % 3 == 0))) {
            System.out.println(" list contains 3 times.");
        } else {
            System.out.println(" list does not contains 3 times.");
        }

        System.out.println(" ----------------- 333 ------------------ ");

        if (numberList1.parallelStream().allMatch(i -> i % 3 == 0)) {
            System.out.println(" all elements is 3 times.");
        } else {
            System.out.println(" not all elements is 3 times.");
        }

        System.out.println(" ----------------- 444 ------------------ ");

        if (numberList1.parallelStream().noneMatch(i -> i % 3 == 0)) {
            System.out.println(" no elements is 3 times.");
        } else {
            System.out.println(" exists elements is 3 times.");
        }

        System.out.println(" ----------------- 555 ----------------- ");

        int firstOccur = numberList1.stream()
                .filter(i -> i % 2 == 0)
                .findFirst()
                .get();
        System.out.println(" target=" + firstOccur);

        System.out.println(" ----------------- 666 ----------------- ");

        int anyOccur = numberList1.stream()
                .filter(i -> i % 2 == 0)
                .findAny()
                .get();
        System.out.println(" any occur=" + anyOccur);

        System.out.println(" ----------------- 777 ----------------- ");

        numberList1.stream()
                .filter(i -> i % 5 == 0)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println(" ----------------- 777 ----------------- ");

        Optional<Integer> firstOccurenceDivisibleByThree = numberList1.stream()
                .filter(i -> i % 3 == 0)
                .findFirst();
        System.out.println("firstOccurenceDivisibleByThree=" + firstOccurenceDivisibleByThree.get());

        System.out.println(" ----------------- 888 ----------------- ");

        int sum = numberList1.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum=" + sum);

        System.out.println(" ----------------- 999 ----------------- ");

        int sum2 = numberList1.stream().reduce(0, Integer::sum);
        System.out.println("sum2=" + sum2);

        System.out.println(" ----------------- 101010 ----------------- ");

        Optional<Integer> sum3 = numberList1.stream().reduce((a, b) -> a + b);
        if (sum3.isPresent()) {
            System.out.println("sum3=" + sum3.get());
        } else {
            System.out.println("sum3=0");
        }

        System.out.println(" ----------------- 111111 ----------------- ");

        Optional<Integer> sum4 = numberList1.stream().reduce(Integer::sum);
        if(sum4.isPresent()) {
            System.out.println("sum4=" + sum4.get());
        } else {
            System.out.println("sum4=0");
        }


    }
}
