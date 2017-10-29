package com.java8.service.applePredicate;

import com.java8.model.Apple;

import java.util.function.Predicate;

public interface ApplePredicate extends Predicate {
    boolean test(Apple apple);

}
