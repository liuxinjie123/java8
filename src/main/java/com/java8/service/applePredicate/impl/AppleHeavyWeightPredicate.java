package com.java8.service.applePredicate.impl;

import com.java8.model.Apple;
import com.java8.service.applePredicate.ApplePredicate;

import java.util.function.Predicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }

    @Override
    public boolean test(Object o) {
        return false;
    }

    @Override
    public Predicate<Apple> negate() {
        return (t) -> !test(t);
    }
}
