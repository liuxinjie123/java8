package com.java8.test.chapter03;

import java.util.Arrays;
import java.util.List;

public class LambdaTest09 {

    public static void main(String[] args) {
        System.out.println(" -------------------- start ----------------- ");
        final int portNum = 1337;
        Runnable r = () -> System.out.println(portNum);
        r.run();
        System.out.println(" -------------------- end ----------------- ");
        List<Integer> list = Arrays.asList(1, 3, 55, 99, 33, 2);
        list.parallelStream().forEach(System.out::println);
    }
}
