package com.java8.model;

public class Letter {
    public static String addHeader(String text) {
        return "From Jack: " + text;
    }
    public static String addFooter(String text) {
        return text + " Kind regards";
    }
    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
