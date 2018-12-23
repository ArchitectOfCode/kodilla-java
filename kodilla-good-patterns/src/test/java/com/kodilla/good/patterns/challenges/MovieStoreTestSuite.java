package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieStoreTestSuite {
    public Map<String, List<String>> testGetMovies() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");
        flashTranslations.add("Blitz");

        Map<String, List<String>> translatedTitles = new HashMap<>();
        translatedTitles.put("IM", ironManTranslations);
        translatedTitles.put("FL", flashTranslations);

        return translatedTitles;
    }

    @Test
    public void testMovieList() {
        //Given
        MovieStore amazingMovies = new MovieStore();
        //When
        String result = amazingMovies.showMovies(testGetMovies());
        System.out.println("Test value: " + result);
        //Then
        Assert.assertEquals("Żelazny Człowiek!Iron Man!Błyskawica!Flash!Blitz", result);
    }
}
