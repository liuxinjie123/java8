package com.java8.predicate.apple.impl;

import com.java8.enu.COLOR;
import com.java8.model.Apple;
import com.java8.predicate.apple.ApplePredicate;
import org.springframework.stereotype.Service;

@Service("redColorService")
public class AppleRedColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return COLOR.RED.equals(apple.getColor());
    }
}
