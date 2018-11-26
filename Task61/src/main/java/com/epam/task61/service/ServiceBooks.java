package com.epam.task61.service;

import com.epam.task61.model.Books;
import com.epam.task61.model.data.DataSource;
import com.epam.task61.model.entity.Book;
import com.epam.task61.util.InputOutputFile;
import com.epam.task61.util.Language;
import com.epam.task61.util.ResorceManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ServiceBooks {
    private Books model = new Books();
    private ResorceManager manager = ResorceManager.INSTANCE;

    public ServiceBooks() {
//        model.setBooks(DataSource.getBooks());
        model.setBooks(InputOutputFile.load());
    }

    public String showAllBooks() {
        return convertBooksInString(model.getBooks());
    }

    private String convertBooksInString(Book[] books) {
        StringBuilder str = new StringBuilder();
        for (Book book : books ) {
            str.append(book);
            str.append("\n");
        }
        return str.toString();
    }

    public String searchBooksByAuthor(String author){
        Book[] books = model.getByAuthor(author);
        if (books.length == 0) {
            return manager.getMessage("noBooks") + author;
        }
        return manager.getMessage("booksWithAuthor") + author + "\n"
                + convertBooksInString(books);
    }

    public String searchBooksByPublisher(String publisher){
        Book[] books = model.getByPublisher(publisher);
        if (books.length == 0) {
            return manager.getMessage("noBooks") + publisher;
        }
        return manager.getMessage("booksWithPublisher") + publisher
                + "\n" + convertBooksInString(books);
    }

    public String searchBooksAfterYear(int year){
        Book[] books = model.getAfterYear(year);
        if (books.length == 0) {
            return manager.getMessage("noBooksAfterYear") + year;
        }
        return manager.getMessage("booksAfterYear")+ year + "\n"
                + convertBooksInString(books);
    }

    public String sortByPublisher() {
        Book[] books = model.getBooks();
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublish().compareTo(o2.getPublish());
            }
        });
        return convertBooksInString(books);
    }

    public void changeLanguage(int input){
        Language[] languages = Language.values();
        Locale locale = languages[input - 1].getLocale();
        manager.changeLocale(locale);
    }

    public void saveBooks() {
        InputOutputFile.save(model.getBooks());
    }
}
