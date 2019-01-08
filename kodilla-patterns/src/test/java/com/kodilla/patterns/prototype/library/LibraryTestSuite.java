package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Example library");
        List<Book> books = new ArrayList<>();
        Book efektywneProgramowanie = new Book("Java. Efektywne programowanie.", "Joshua Bloch", LocalDate.of(2018, 01, 01));
        Book javaPodstawy = new Book("Java. Podstawy. Wydanie X", "Cay S. Horstmann", LocalDate.of(2016, 07, 05));
        Book brightonRock = new Book("Brighton Rock", "Graham Greene", LocalDate.of(1938, 01, 04));
        Book czystyKod = new Book("Czysty kod. Podręcznik dobrego programisty", "Robert C. Martin", LocalDate.of(2015, 01, 01));
        Book lornaDoone = new Book("Lorna Doone", "R.D. Blackmore", LocalDate.of(1869, 01, 12));
        Book java9Przewodnik = new Book("Java 9. Przewodnik doświadczonego programisty. Wydanie II", "Cay S. Horstmann", LocalDate.of(2018, 06, 30));
        Book algorytmyIlustrowanyPrzewodnik = new Book("Algorytmy. Ilustrowany przewodnik", "Aditya Bhargava", LocalDate.of(2017, 03, 05));
        Book theCallOfTheWind = new Book("The Call of the Wild", "Jack London", LocalDate.of(1903, 1, 21));

        books.add(efektywneProgramowanie);
        books.add(javaPodstawy);
        books.add(brightonRock);
        books.add(czystyKod);
        books.add(lornaDoone);
        books.add(java9Przewodnik);
        books.add(algorytmyIlustrowanyPrzewodnik);
        books.add(theCallOfTheWind);
        library.getBooks().addAll(books);

        //Making a shallow copy of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Shallow copy of library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep copy of library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        System.out.println(library.toString());
        System.out.println(clonedLibrary.toString());

        System.out.println("REMOVING " + brightonRock + " FROM " + library.getName().toUpperCase() + "\n");
        library.getBooks().remove(brightonRock);

        //Then
        System.out.println(clonedLibrary.toString());
        System.out.println(deepClonedLibrary.toString());

        Assert.assertEquals(7, library.getBooks().size());
        Assert.assertEquals(7, clonedLibrary.getBooks().size());
        Assert.assertEquals(8, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(clonedLibrary.getBooks(), deepClonedLibrary.getBooks());
    }
}
