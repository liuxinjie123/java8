package com.java8.test.chapter02;

public class ThreadLambdaTest01 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println(" Hello Lambda! "));
        t.start();
    }
}
