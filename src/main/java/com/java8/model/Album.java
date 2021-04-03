package com.java8.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Album implements Serializable {
    /**
     * name
     */
    private String name;

    /**
     * tracks
     */
    private List<Track> trackList;
}
