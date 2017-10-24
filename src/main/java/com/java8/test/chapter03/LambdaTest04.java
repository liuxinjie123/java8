package com.java8.test.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaTest04 {

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> String.valueOf(br.read()));
        System.out.println(oneLine + "\n");
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLine + "\n");
    }
}
