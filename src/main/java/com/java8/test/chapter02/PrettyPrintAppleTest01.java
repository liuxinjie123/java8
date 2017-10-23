package com.java8.test.chapter02;

import com.java8.dto.Apple;
import com.java8.enu.COLOR;
import com.java8.service.appleFormat.impl.AppleFancyFormatter;
import com.java8.service.appleFormat.impl.AppleSimpleFormatter;
import com.java8.service.appleFormat.impl.PrettyPrintApple;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintAppleTest01 {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200.0);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, 151.0);
        appleList.add(b);
        Apple c = new Apple("C", COLOR.YELLOW, 100.0);
        appleList.add(c);

        PrettyPrintApple.prettyPrintApple(appleList, new AppleFancyFormatter());
        System.out.println(" ------------------------------------ ");
        PrettyPrintApple.prettyPrintApple(appleList, new AppleSimpleFormatter());
    }
}
