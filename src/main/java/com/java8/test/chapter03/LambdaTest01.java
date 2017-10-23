package com.java8.test.chapter03;

public class LambdaTest01 {
    public static void process(Runnable t) {
        t.run();
    }
    public static void main(String[] args) {
        Runnable t1 = () -> System.out.println("Hello World 1");

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(t1);
        process(t2);
        process(() -> System.out.println("Hello World 3"));
    }
}
