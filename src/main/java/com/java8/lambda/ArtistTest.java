package com.java8.lambda;

import com.java8.model.Artist;
import com.java8.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class ArtistTest {

    private static final String SHANG_HAI = "Shanghai";

    public static void main(String[] args) {
       List<Artist> artistList = getArticleList();
       artistList.forEach(artist -> System.out.println(artist));

       artistList.stream()
               .filter(artist -> {
                   System.out.println(artist.getName());
                   return SHANG_HAI.equals(artist.getCity());
               }).count();

        System.out.println("-----------------------");

       List<String> collected = Stream.of("a", "b", "c")
               .map(string -> string.toUpperCase())
               .collect(Collectors.toList());
        System.out.println(collected);

        System.out.println("-----------------------");

        List<Integer> together = Stream.of(asList(1,2), asList(3,6))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        System.out.println(together);

        System.out.println("-----------------------");

        Integer minNumber = together.stream().min(Integer::compareTo).get();
        Integer maxNumber = together.stream().max(Integer::compareTo).get();
        System.out.println("minNumber = " + minNumber);
        System.out.println("maxNumber = " + maxNumber);

        System.out.println("-----------------------");

        int sum = Stream.of(1, 3, 9)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println("sum=" + sum);

        int sum2 = Stream.of(1, 6, 9, 22, 33)
                .reduce(10, (obj1, obj2) -> obj1 + obj2);
        System.out.println("sum2=" + sum2);

        System.out.println("-----------------------");

        int sum3 = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                2),
        3);
        System.out.println("sum3=" + sum3);
    }

    private static BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;

    private static List<Artist> getArticleList() {
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist();
        artist.setId(1L).setName("jack").setCity(SHANG_HAI);
        artistList.add(artist);

        artist = new Artist();
        artist.setId(2L).setName("tom").setCity(SHANG_HAI);
        artistList.add(artist);

        artist = new Artist();
        artist.setId(3L).setName("wow").setCity(SHANG_HAI);
        artistList.add(artist);

        return artistList;
    }
}
