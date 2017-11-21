package com.java8.model;

import com.java8.enu.DishType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish implements Serializable {
    private String name;
    private boolean vegetarian;
    private int calories;
    private DishType dishType;

}
