package com.java8.controller;

import com.java8.enu.COLOR;
import com.java8.model.Apple;
import com.java8.predicate.apple.ApplePredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/apple")
@RestController
public class AppleController {
    @Autowired
    @Qualifier("redColorService")
    private ApplePredicate applePredicate;

    @GetMapping("/test/01")
    public Object test001() {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, 151);
        appleList.add(b);
        Apple c = new Apple("C", COLOR.YELLOW, 100);
        appleList.add(c);

        List<Apple> redAppleList = applePredicate.filterApples(appleList, Apple::isRedApple);
        redAppleList.parallelStream().forEach(apple -> System.out.println(apple));
        return redAppleList;
    }

}
