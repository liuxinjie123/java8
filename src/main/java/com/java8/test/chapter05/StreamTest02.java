package com.java8.test.chapter05;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest02 {
    public static void main(String[] args) {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);
        System.out.println(" count=" + evenNumbers.count());

        System.out.println("\n ----------------- 111 --------------- ");

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a*a + b*b)})
                );
        pythagoreanTriples.limit(5).forEach(e -> System.out.println(e[0]+ " " + e[1] + " " + e[2]));

        System.out.println("\n ----------------- 222 --------------- ");

        Stream<int[]> nums = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)})
                );
        nums.limit(10).forEach(e -> System.out.println(e[0] + " " + e[1] + " " + e[2]));

        System.out.println("\n ----------------- 333 --------------- ");

        nums = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                                IntStream.rangeClosed(1, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)})
                );
        nums.limit(10).forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println("\n ----------------- 444 --------------- ");

        Stream<int[]> nums2= IntStream.rangeClosed(1, 30).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 30)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a*a + b*b)})
                );
        nums2.forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println("\n ----------------- 555 --------------- ");

        Stream<int[]> nums3 = IntStream.rangeClosed(1, 30).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 30)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a*a + b*b)})
                );
        nums3.forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println("\n ----------------- 666 --------------- ");

        Stream<double[]> nums5 = IntStream.rangeClosed(1, 30).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 30)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                ).filter(e -> e[2] % 1 == 0);
        nums5.forEach(e -> System.out.println(Arrays.toString(e)));

    }
}
