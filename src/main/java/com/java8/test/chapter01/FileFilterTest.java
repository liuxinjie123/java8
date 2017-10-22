package com.java8.test.chapter01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FileFilterTest {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.exists();
//                return pathname.isHidden();
            }
        });

        Arrays.asList(hiddenFiles).parallelStream().forEach(file -> System.out.println(file.getName()));

    }
}
