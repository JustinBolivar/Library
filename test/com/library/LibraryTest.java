package com.library;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class LibraryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeEach
    void setup() {
        BookRentalSystem library = new BookRentalSystem();
        library.clearLibrary();
        
        outContent.reset();
        System.setOut(new PrintStream(outContent));

    }
    @Order(1)
    @Test
    void testAddBook_CreateBook_ShouldReturnNotNullAndIsRentedIsFalse() {
        FictionBook manga = new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018);
        
        
        assertNotNull(manga,()-> "The length of the Library is not null");
        assertFalse(manga.isRented());
    }
    @Order(2)
    @Test
    void testRent_AddBookAndRent_ShouldReturnTrue() {
        FictionBook manga = new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018);
        
        assertFalse(manga.isRented());
        manga.rent();
        assertTrue(manga.isRented());
    }
    @Order(3)
    @Test
    void testAddBooks_AddTwoBooksAndCheckIfLengthIsAlsoTwo_ShouldReturnTwo() {
        BookRentalSystem library = new BookRentalSystem();
        library.AddBook(new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018));
        library.AddBook(new NonFictionBook("Atomic Habits", "James Clear", 2018));
        
        int expectedLength = 2;
        
        assertEquals(library.getBookLength(),expectedLength,()->"The lenght of the library does not equal 4");
    }
    @Order(4)
    @Test
    void testRentBookWithValidIndex_AddTwoBooksAndRentOneBook_ShouldReturnTrue() {
        BookRentalSystem library = new BookRentalSystem();
        library.AddBook(new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018));
        library.AddBook(new NonFictionBook("Atomic Habits", "James Clear", 2018));
        
        library.rentBooks(0);
        
        assertTrue(library.isBookRented(0),()->"The book is not Rented");
    }
    @Order(5)
    @Test
    void testRentBookWithInvalidIndex_AddOneBooksAndRentInvalidIndex_ShouldReturnError() {
        BookRentalSystem library = new BookRentalSystem();
        library.AddBook(new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018));
        
        assertThrows(IndexOutOfBoundsException.class,()->library.rentBooks(1),"Should throw Index Out of Bounds");
    }
    @Order(6)
    @Test
    void testAllDisplayBooks_AddTwoBooksAndCheckIfMatch_ShouldReturnTrue() {        
        BookRentalSystem library = new BookRentalSystem();
        library.AddBook(new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018));
        library.AddBook(new NonFictionBook("Atomic Habits", "James Clear", 2018));
        library.displayBooks(); 
        
        String actualOutput = outContent.toString().trim();
        
        String expectedOutput = 
            "Title: ChainsawMan, Author: Fujimoto Tatsuki, Year Published: 2018, Rented: false" + System.lineSeparator() +
            "Title: Atomic Habits, Author: James Clear, Year Published: 2018, Rented: false";
        
        assertEquals(expectedOutput, actualOutput, "The displayed book list does not match the expected output.");
    }
    @Order(7)
    @Test
    void testAllDisplayRentedBooks_AddTwoBooksAndRentOneBookCheckIfItMatches_ShouldReturnTrue() {        
        BookRentalSystem library = new BookRentalSystem();
        library.AddBook(new FictionBook("ChainsawMan", "Fujimoto Tatsuki", 2018));
        library.AddBook(new NonFictionBook("Atomic Habits", "James Clear", 2018));
        library.rentBooks(0);
        library.displayBooks(); 
        
        String actualOutput = outContent.toString().trim();
        
        String expectedOutput = 
            "Title: ChainsawMan, Author: Fujimoto Tatsuki, Year Published: 2018, Rented: true" + System.lineSeparator() +
            "Title: Atomic Habits, Author: James Clear, Year Published: 2018, Rented: false";
        
        assertEquals(expectedOutput, actualOutput, "The displayed book list does not match the expected output.");
    }
    @Order(8)
    @Test
    void testMain() {
        int expectedResult = 1;
        BookRentalSystem.main(null);

        int result = 1;
        assertEquals(expectedResult, result, () -> "Main Test");
    }
}
