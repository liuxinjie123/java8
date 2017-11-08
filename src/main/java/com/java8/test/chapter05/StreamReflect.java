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

        System.out.println(" ----------------- 121212 ----------------- ");

        int max = numberList1.stream().reduce(Integer::max).get();
        System.out.println("max=" + max);

        System.out.println(" ----------------- 131313 ----------------- ");

        Optional<Integer> max2 = numberList1.stream().reduce(Integer::max);
        System.out.println("max2=" + max2.get());

        System.out.println(" ----------------- 141414 ----------------- ");

        int max3 = numberList1.stream().reduce(0, (a, b) -> a < b ? b : a);
        System.out.println("max3=" + max3);

        System.out.println(" ----------------- 151515 ----------------- ");

        Optional<Integer> max4 = numberList1.stream().reduce((a, b) -> a < b ? b : a);
        System.out.println("max4=" + max4.get());

        System.out.println(" ----------------- 161616 ----------------- ");

        int count = numberList1.parallelStream()
                .map(i -> 1)
                .reduce(0, Integer::sum);
        System.out.println("count=" + count);

        System.out.println(" ----------------- 171717 ----------------- ");

        int count2 = numberList1.parallelStream()
                .map(i -> 1)
                .reduce(Integer::sum)
                .get();
        System.out.println("count2=" + count2);

        System.out.println(" ----------------- 181818 ----------------- ");

        long count3 = numberList1.parallelStream().count();
        System.out.println("count3=" + count3);

        System.out.println(" ----------------- 191919 ----------------- ");



    }
}
