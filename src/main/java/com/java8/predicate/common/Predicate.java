package com.java8.predicate.common;

import com.java8.predicate.apple.ApplePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    default Predicate<T> and(Predicate other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

}
