package com.java8.service.applePredicate;

import com.java8.model.Apple;

import java.util.Objects;
import java.util.function.Predicate;

public interface ApplePredicate  {
    boolean test(Apple apple);

    default ApplePredicate negate() {
        return (t) -> !test(t);
    }

    default ApplePredicate and(ApplePredicate other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default ApplePredicate or(ApplePredicate other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }
}
