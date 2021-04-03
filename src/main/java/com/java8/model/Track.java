package com.java8.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Track implements Serializable {
    /**
     * nane
     */
    private String name;

    /**
     * time
     */
    private Long time;
}
