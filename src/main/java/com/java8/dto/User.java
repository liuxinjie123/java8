package com.java8.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String userId;
    private String username;
    private String phone;

    public User(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }
}
