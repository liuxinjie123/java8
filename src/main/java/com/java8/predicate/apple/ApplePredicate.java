package com.java8.predicate.apple;

import com.java8.model.Apple;

import java.util.ArrayList;
import java.util.List;
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

    default List<Apple> filterApples(List<Apple> appleList, ApplePredicate p) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }
}
