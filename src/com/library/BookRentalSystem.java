package com.library;

import java.util.ArrayList;

public class BookRentalSystem {
    public static ArrayList<Book> library = new ArrayList<>();
    
    public void addBooks() {
        
    }
    
    public void returnBooks() {
        
    }

    public static void main(String[] args) {
        library.add( new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954)); 
        library.add(new FictionBook("To Kill a Mockingbird", "Harper Lee", 1960));  
        library.add( new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
        library.add( new NonFictionBook("Guns, Germs, and Steel", "Jared Diamond ",  1997));
        
        for (Book bookItem : library) {
            System.out.println(bookItem.toString());
        }
        
        

    }

}
