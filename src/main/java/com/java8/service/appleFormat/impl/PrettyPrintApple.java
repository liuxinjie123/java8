package com.java8.service.appleFormat.impl;

import com.java8.dto.Apple;
import com.java8.service.appleFormat.AppleFormatter;

import java.util.List;

public class PrettyPrintApple {
    public static void prettyPrintApple(List<Apple> appleList, AppleFormatter appleFormatter) {
        for (Apple apple : appleList) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }
}
