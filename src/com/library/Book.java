package com.library;

public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean isRented;
    
    public Book(String title, String author, int yearPublished) {
        super();
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isRented = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        isRented = true;
    }
    
    @Override
    public String toString() {
        return "Title: " + this.title + ", Author: " + this.author + " Year Published: " + this.yearPublished;
    }
}
