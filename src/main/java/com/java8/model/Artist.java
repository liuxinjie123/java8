package com.java8.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

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

    private List<Album> albumList;

//    public Map<Artist, List<Album>> albumByArtist(Stream<Album> albums) {
//        return albums.collect(groupingBy(album -> album.getTrackList()));
//    }

}




