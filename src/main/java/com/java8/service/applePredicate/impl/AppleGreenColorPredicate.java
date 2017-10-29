package com.java8.service.applePredicate.impl;

import com.java8.model.Apple;
import com.java8.enu.COLOR;
import com.java8.service.applePredicate.ApplePredicate;

import java.util.function.Predicate;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return COLOR.GREEN.equals(apple.getColor());
    }

}
