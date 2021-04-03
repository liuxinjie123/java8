package com.java8.service.parent;

public interface Parent {
    public default void welcome() {
        System.out.println(" Welcome to Java8's world.");
    }
}
