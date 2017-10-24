package com.java8.test.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaTest03 {
    public static String processFile() throws IOException {
        try (
                BufferedReader br =
                        new BufferedReader(new FileReader("./src/main/resources/data.txt"))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String content = processFile();
        System.out.println(content);
    }
}
