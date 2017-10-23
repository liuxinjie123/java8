package com.java8.service.appleFormat.impl;

import com.java8.dto.Apple;
import com.java8.service.appleFormat.AppleFormatter;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple.";
    }
}
