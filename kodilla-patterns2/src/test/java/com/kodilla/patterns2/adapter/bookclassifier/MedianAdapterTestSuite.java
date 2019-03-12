package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> booksSet = new HashSet<Book>();
        booksSet.add(new Book("Joshua Bloch", "Java. Efektywne programowanie.", 2018, "201851238"));
        booksSet.add(new Book("Cay S. Horstmann", "Java. Podstawy. Wydanie X", 2016, "201628784"));
        booksSet.add(new Book("Graham Greene", "Brighton Rock", 1938, "193855287"));
        booksSet.add(new Book("Robert C. Martin", "Czysty kod. Podręcznik dobrego programisty", 2015, "201587734"));
        booksSet.add(new Book("R.D. Blackmore", "Lorna Doone", 1869, "186951951"));
        booksSet.add(new Book("Cay S. Horstmann", "Java 9. Przewodnik doświadczonego programisty. Wydanie II", 2018, "201846891"));
        booksSet.add(new Book("Aditya Bhargava", "Algorytmy. Ilustrowany przewodnik", 2017, "201734356"));

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(booksSet);

        //Then
        assertEquals(2015, publicationYearMedian);
    }

    @Test
    public void publicationYearMedianTestWithEvenNumOfBooks() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> booksSet = new HashSet<Book>();
        booksSet.add(new Book("Cay S. Horstmann", "Java. Podstawy. Wydanie X", 2016, "201628784"));
        booksSet.add(new Book("Graham Greene", "Brighton Rock", 1938, "193855287"));
        booksSet.add(new Book("Robert C. Martin", "Czysty kod. Podręcznik dobrego programisty", 2015, "201587734"));
        booksSet.add(new Book("R.D. Blackmore", "Lorna Doone", 1869, "186951951"));
        booksSet.add(new Book("Aditya Bhargava", "Algorytmy. Ilustrowany przewodnik", 2017, "201734356"));
        booksSet.add(new Book("Jack London", "The Call of the Wild", 1903, "190344315"));

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(booksSet);

        //Then
        assertEquals(1976, publicationYearMedian);
    }
}
