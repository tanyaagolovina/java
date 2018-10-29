package model;

import model.entity.Book;
import model.entity.booksComparator.BooksComparator;

import java.util.Arrays;

public class Books {
    private Book[] books;

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] findByAuthor(String author){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for(int book = 0; book < books.length; book++ ){
           if(books[book].getAuthor().equalsIgnoreCase(author)) {
               temp[counter++] = books[book];
           }
        }
        return Arrays.copyOf( temp, counter);
    }
    public Book[] findByPublisher(String publisher){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for(int book = 0; book < books.length; book++ ){
            if(books[book].getPublisher().equalsIgnoreCase(publisher)) {
                temp[counter++] = books[book];
            }
        }
        return Arrays.copyOf( temp, counter);

    }
    private int parseInt(String year){
        return Integer.parseInt(year);
    }
    public Book[] findByYear(String year){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for(int book = 0; book < books.length; book++ ){
            if(books[book].getYear()>Integer.parseInt(year)) {
                temp[counter++] = books[book];
            }
        }
        return Arrays.copyOf( temp, counter);

    }
    public Book[] orderByPublisher(){
        Arrays.sort( books, new BooksComparator());
        return Arrays.copyOf( books, books.length);
    }

}
