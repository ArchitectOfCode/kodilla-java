package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookLibraryTestSuite {
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given / Arrange
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Deirectories", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When / Act
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then / Assert
        assertEquals(4, theListOfBooks.size());
    }

    private List<Book> generateListOfBooks (int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given / Arrange
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfBooks(15);
        List<Book> resultListOf40Books = generateListOfBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        // When / Act
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        // Then / Assert
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFregmentShorterThan3() {
        // Given / Arrange
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        // When / Act
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then / Assert
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    // user has no borrowed books
    public void testNoBooksInHandsOf() {
        // Given / Arrange
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Marian", "Niepiśmienny", "94061234213");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(generateListOfBooks(0));
        // When / Act
        List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then / Assert
        assertEquals(0, theListOf0Books.size());

    }

    @Test
    // user has borrowed one book
    public void testOneBookInHandsOf() {
        // Given / Arrange
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Marta", "Książka dziennie", "85032385235");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(generateListOfBooks(1));
        // When / Act
        List<Book> theListOf1Book = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then / Assert
        assertEquals(1, theListOf1Book.size());

    }

    @Test
    // user has borrowed five books
    public void testFiveBooksInHandsOf() {
        // Given / Arrange
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Kazik", "Kwartał", "73020712645");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(generateListOfBooks(5));
        // When / Act
        List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then / Assert
        assertEquals(5, theListOf5Books.size());

    }
}
