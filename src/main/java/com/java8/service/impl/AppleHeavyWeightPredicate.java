package com.java8.service.impl;

import com.java8.dto.Apple;
import com.java8.service.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
