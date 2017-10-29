package com.java8.model;

import com.java8.enu.DEPT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String code;
    private String name;

    public Department(DEPT dept) {
        this.code = dept.code;
        this.name = dept.name;
    }
}
