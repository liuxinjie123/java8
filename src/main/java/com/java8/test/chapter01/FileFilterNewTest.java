package com.java8.test.chapter01;

import java.io.File;
import java.util.Arrays;

public class FileFilterNewTest {
    public static void main(String[] args) {
//        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        File[] hiddenFiles = new File(".").listFiles(File::exists);
        Arrays.asList(hiddenFiles).parallelStream().forEach(file -> System.out.println(file.getName()));
    }
}
