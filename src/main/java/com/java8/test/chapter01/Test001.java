package com.java8.test.chapter01;

import com.java8.utils.MyMathUtils;

public class Test001 {
    public static void main(String[] args) {
        int x = 1;
        int y = MyMathUtils.oper(x, MyMathUtils::add);
        System.out.println(y);
        y = MyMathUtils.oper(x, MyMathUtils::minus);
        System.out.println(y);
    }
}
