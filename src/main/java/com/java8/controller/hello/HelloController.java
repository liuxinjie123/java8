package com.java8.controller.hello;

import com.java8.enu.COLOR;
import com.java8.model.Apple;
import com.java8.predicate.apple.ApplePredicate;
import com.java8.predicate.apple.impl.AppleGreenColorPredicate;
import com.java8.predicate.apple.impl.AppleRedColorPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/hello")
@RestController
public class HelloController {
    @Autowired
    @Qualifier("greenColorService")
    private ApplePredicate greenColorService;
    @Autowired
    @Qualifier("redColorService")
    private ApplePredicate redColorService;

    @GetMapping("/world")
    public Object helloWorld() {
        List<Apple> appleList = new ArrayList<>();
        Apple a = new Apple("A", COLOR.GREEN, 200);
        appleList.add(a);
        Apple b = new Apple("B", COLOR.RED, 151);
        appleList.add(b);
        Apple c = new Apple("C", COLOR.YELLOW, 100);
        appleList.add(c);

        List<Apple> greenAppleList = greenColorService.filterApples(appleList, new AppleGreenColorPredicate());
        greenAppleList.parallelStream().forEach(System.out::println);

        System.out.println(" -------------------------------------------- ");

        List<Apple> redAppleList = redColorService.filterApples(appleList, new AppleRedColorPredicate());
        redAppleList.parallelStream().forEach(System.out::println);
        return redAppleList;
    }
}
