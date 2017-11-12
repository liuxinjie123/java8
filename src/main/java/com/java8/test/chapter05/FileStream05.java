package com.java8.test.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FileStream05 {
    public static void main(String[] args) {
        long uniqueWords = 0;
        List<String> wordList = new ArrayList<>();
        try (
                Stream<String> lines = Files.lines(Paths.get("files/chapter05/data.txt"), Charset.defaultCharset());
                Stream<String> words = Files.lines(Paths.get("files/chapter05/data.txt"), Charset.defaultCharset())
        ) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            wordList = words.flatMap(line -> Arrays.stream(line.split(" ")))
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" uniqueWords=" + uniqueWords);
        wordList.parallelStream().forEach(System.out::println);
    }
}
