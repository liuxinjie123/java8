package com.java8.service.applePredicate.impl;

import com.java8.model.Apple;
import com.java8.enu.COLOR;
import com.java8.service.applePredicate.ApplePredicate;

public class AppleRedColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return COLOR.RED.equals(apple.getColor());
    }
}
