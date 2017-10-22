package com.java8.test.chapter01;

import com.java8.dto.Department;
import com.java8.dto.Employee;
import com.java8.enu.DEPT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamTest01 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee a = new Employee("AAA", BigDecimal.valueOf(10000), new Department(DEPT.IT));
        employeeList.add(a);
        Employee b = new Employee("BBB", BigDecimal.valueOf(6666), new Department(DEPT.CUSTOMER));
        employeeList.add(b);
        Employee c = new Employee("CCC", BigDecimal.valueOf(8888), new Department(DEPT.IT));
        employeeList.add(c);

        employeeList.stream().forEach(e -> System.out.println(e.toString()));
        System.out.println(" ----------------------------------------- ");
        Map<Department, List<Employee>> employeeByDept = employeeList.stream()
                .filter((Employee e) -> e.getSalary().compareTo(BigDecimal.valueOf(6600)) == 1)
                .collect(groupingBy(Employee::getDepartment));
        employeeByDept.values().forEach(e -> System.out.println(e.toString()));
    }
}

