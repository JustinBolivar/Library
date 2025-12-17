package com.library;

public class Book {
    /***
     * this is the title field containing the books title.
     */
    private String title;
    /***
     * This is the author field containing the books author.
     */
    private String author;
    /***
     * This the the year Published field containing the books published year.
     */
    private int yearPublished;
    /***
     * This is the boolean is Rented field that shows if a book is rented.
     */
    private boolean isRented;

    /***
     * This is the Parent Book constructor.
     * @param thisTitle
     * @param thisAuthor
     * @param thisYearPublished
     */
    public Book(final String thisTitle, final String thisAuthor,
            final int thisYearPublished) {
        super();
        title = thisTitle;
        author = thisAuthor;
        yearPublished = thisYearPublished;
        isRented = false;
    }
    /***
     * this is the getter for the field isRented.
     * @return isRented
     */
    public boolean isRented() {
        return isRented;
    }
    /***
     * This is the function to rent a book.
     */
    public void rent() {
        isRented = true;
    }
    /***
     * This is to override the ToString function to properly display the books.
     */
    @Override
    public String toString() {
        return "Title: " + this.title + ", Author: " + this.author
                + ", Year Published: " + this.yearPublished + ", Rented: " + this.isRented;
    }
}
