package com.java8.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Artist implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * city
     */
    private String city;

    /**
     * salary
     */
    private Long salary;

}




