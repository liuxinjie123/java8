package com.java8.lambda;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ElementSort {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 3, 66, 6, 9);
        List<Integer> sameOrder = numbers.stream().collect(toList());

    }
}
