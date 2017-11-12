package com.java8.test.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest03 {
    public static void main(String[] args) {
        System.out.println(" ----------------- 001 ---------------- ");
        Stream<String> stream = Stream.of("Java8", "lambda", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        System.out.println(" ----------------- 002 ---------------- ");

        int[] numbers = {1, 2, 3, 4, 5};
        int intSum = Arrays.stream(numbers).sum();
        System.out.println("intSum=" + intSum);

        System.out.println(" ----------------- 003 ---------------- ");



    }
}
