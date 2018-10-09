package model.entity.model;

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
        for(int i=0; i < books.length; i++ ){
           if(books[i].getAuthor().equalsIgnoreCase(author)) {
               temp[counter++] = books[i];
           }
        }
        return Arrays.copyOf( temp, counter);
    }
    public Book[] findByPublisher(String publisher){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for(int i=0; i < books.length; i++ ){
            if(books[i].getPublisher().equalsIgnoreCase(publisher)) {
                temp[counter++] = books[i];
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
        for(int i=0; i < books.length; i++ ){
            if(books[i].getYear()>Integer.parseInt(year)) {
                temp[counter++] = books[i];
            }
        }
        return Arrays.copyOf( temp, counter);

    }
    //тут ошибка, разберись
    public Book[] orderByPublisher(){
        Book[] temp = new Book[books.length];
        Arrays.sort(temp, new BooksComparator());
        return Arrays.copyOf( temp, books.length);
    }

}
