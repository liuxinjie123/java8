package com.java8.service.impl;

import com.java8.dto.Apple;
import com.java8.enu.COLOR;
import com.java8.service.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return COLOR.GREEN.equals(apple.getColor());
    }
}
