package com.java8.service.functiontest;

public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
