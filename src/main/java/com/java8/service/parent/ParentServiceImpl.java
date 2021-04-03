package com.java8.service.parent;

import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements Parent {
    @Override
    public void welcome() {
        System.out.println(" Welcome to Java8's Service world.");
    }
}
