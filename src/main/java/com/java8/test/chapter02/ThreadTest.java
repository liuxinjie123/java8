package com.java8.test.chapter02;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello World !"));
        t.start();
    }
}
