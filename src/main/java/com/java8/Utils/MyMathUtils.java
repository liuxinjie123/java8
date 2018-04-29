package com.java8.Utils;

import java.util.function.Function;

public class MyMathUtils {

    public static int add(int x) {
        return x + 1;
    }

    public static int minus(int x) {
        return x - 1;
    }

    public static int oper(int x, Function<Integer, Integer> action){
        return action.apply(x);
    }
}
