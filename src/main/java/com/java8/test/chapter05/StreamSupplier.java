package com.java8.test.chapter05;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class StreamSupplier {
    public static void main(String[] args) {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(30)
                .forEach(System.out::println);
    }
}
