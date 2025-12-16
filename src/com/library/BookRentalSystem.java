package com.library;

import java.util.ArrayList;

public class BookRentalSystem {
    /**
     * Initialize Array List of Books.
     */
    private static ArrayList<Book> library = new ArrayList<>();

    /**
     * Function that adds books into the Array List.
     */
    public void addBooks() {
        final int year1 = 1954;
        final int year2 = 1960;
        final int year3 = 2000;
        final int year4 = 1997;
        library.add(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien",
                year1));
        library.add(
                new FictionBook("To Kill a Mockingbird", "Harper Lee", year2));
        library.add(
                new NonFictionBook("The Tipping Point", "M. Gladwell", year3));
        library.add(new NonFictionBook("Guns, Germs, and Steel",
                "Jared Diamond ", year4));
    }
    /**
     * Function to rent a book.
     * @param index
     */
    public void rentBooks(final int index) {
        library.get(index).rent();
    }
    
    public int getBookLength() {
        return library.size();
    }
    
    public void AddBook(Book x) {
        library.add(x);
    }
    
    public void clearLibrary() {
        library.clear();
    }
    
    public boolean isBookRented(int index) {
        return library.get(index).isRented();
    }
    
    public void displayBooks() {
        for (Book book : library) {
            System.out.println(book); 
        }
    }
    /**
     * Main Function.
     * @param args
     */
    public static void main(final String[] args) {
        BookRentalSystem rentalLibrary = new BookRentalSystem();
        rentalLibrary.addBooks();
        rentalLibrary.rentBooks(0);
        rentalLibrary.rentBooks(2);
        for (Book bookItem : library) {
            System.out.println(bookItem.toString());
        }
        System.out.println("\n");
        System.out.println("Rented Books: ");
        for (Book bookItem : library) {
            if (bookItem.isRented()) {
                System.out.println(bookItem.toString());
            }
        }
    }
}
