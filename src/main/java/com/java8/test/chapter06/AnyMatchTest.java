package com.java8.test.chapter06;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AnyMatchTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("hello", "love", "wow");
        List<String> list2 = Arrays.asList("world", "jack", "love", "shanghai", "dream");

        boolean exists = list1.parallelStream()
                .anyMatch(
                        l -> list2.parallelStream()
                        .anyMatch(l2 -> l2.equals(l))
                );

        System.out.println("result1=" + exists);

        Optional<String> exist2 = list1.parallelStream()
                .filter(
                        l -> list2.parallelStream()
                        .anyMatch(l2 -> l2.equals(l))
                ).findAny();
        boolean result2 = false;
        if (exist2.isPresent()) {
            result2 = true;
        }
        System.out.println("result2=" + result2);
    }
}
