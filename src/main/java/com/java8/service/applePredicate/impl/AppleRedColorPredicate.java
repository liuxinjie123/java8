package com.java8.service.applePredicate.impl;

import com.java8.model.Apple;
import com.java8.enu.COLOR;
import com.java8.service.applePredicate.ApplePredicate;

import java.util.function.Predicate;

public class AppleRedColorPredicate<T> implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return COLOR.RED.equals(apple.getColor());
    }
}
