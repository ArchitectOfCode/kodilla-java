package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile().replaceAll("%20", " "));
            // Need to find better solution than replacing %20 with space to be able to use paths with spaces
            // System.out.println(file.getPath());

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
