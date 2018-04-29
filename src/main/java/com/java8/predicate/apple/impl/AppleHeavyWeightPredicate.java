package com.java8.predicate.apple.impl;

import com.java8.model.Apple;
import com.java8.predicate.apple.ApplePredicate;
import org.springframework.stereotype.Service;

@Service("heavyWeightService")
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
