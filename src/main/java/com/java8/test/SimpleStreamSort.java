package com.java8.test;

import com.java8.dto.User;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class SimpleStreamSort {
    public static void main(String[] args) {
        User u1 = new User("jack", "15618177577");
        User u2 = new User("lxj", "18621091609");
        User u3 = new User("hello", "17602133229");
        List userList = Arrays.asList(u1, u2, u3);
        userList.stream().forEach(u -> System.out.println(u.toString()));
        userList.sort(comparing(User::getUsername));
        userList.stream().forEach(u -> System.out.println(u.toString()));
    }
}
