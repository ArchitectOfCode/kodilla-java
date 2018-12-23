package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MovieStore {
    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

    public static void main(String args[]) {
        System.out.println("test");

        MovieStore amazingMovies = new MovieStore();
        amazingMovies.getMovies()
                .entrySet()
                .forEach(System.out::println);



        /*Stream.iterate(1, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        People.getList().stream()
                .forEach(System.out::println);*/
    }
}
