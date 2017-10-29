package com.java8.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Employee implements Serializable {
    private Long id;
    private String userId;
    private String name;
    private String phone;
    private BigDecimal salary;
    private Department department;

    public Employee(String name, BigDecimal salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
