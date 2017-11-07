package com.java8.test.chapter03;

import com.java8.model.Letter;

import java.util.function.Function;

public class LambdaTest16 {
    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::addFooter)
                .andThen(Letter::checkSpelling);
        String text = "Welcome come to Shanghai.";
        String targetText = transformationPipeline.apply(text);
        System.out.println("text1=" + targetText);
    }
}
