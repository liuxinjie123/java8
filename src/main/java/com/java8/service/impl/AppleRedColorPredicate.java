package com.java8.service.impl;

import com.java8.dto.Apple;
import com.java8.enu.COLOR;
import com.java8.service.ApplePredicate;

public class AppleRedColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return COLOR.RED.equals(apple.getColor());
    }
}
