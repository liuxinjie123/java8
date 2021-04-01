package com.java8.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class HelloWorld {
    public static void main(String[] args) {
        Runnable noArguments = () -> System.out.println("Hello World");
        new Thread(noArguments).start();

        Long a = 3L;
        Long b = 9L;
        Long res = add.apply(a, b);
        System.out.println(" res1 = " + res);
        res = add2.apply(a, b);
        System.out.println(" res2 = " + res);

        Map<String, String> map = new HashMap<>();
    }


    static BinaryOperator<Long> add = (x, y) -> x+y;
    static BinaryOperator<Long> add2 = (Long x, Long y) -> x+y;
}
