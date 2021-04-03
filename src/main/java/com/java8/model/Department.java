package com.java8.model;

import com.java8.enu.DEPT;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Department implements Serializable {
    private String code;
    private String name;

    public Department(DEPT dept) {
        this.code = dept.code;
        this.name = dept.name;
    }
}
