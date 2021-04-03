package com.java8.service.parent;

public interface Child extends Parent {
    @Override
    default void welcome() {
        System.out.println(" Welcome to children's world.");
    }
}
