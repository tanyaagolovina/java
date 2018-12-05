package com.epam.task61.service;

import com.epam.task61.model.Books;
import com.epam.task61.model.dao.BooksDAO;
import com.epam.task61.model.dao.SQLStatementsBook;
import com.epam.task61.model.entity.Book;
import com.epam.task61.util.InputOutputFile;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.Language;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ServiceBooks {
    private Books model = new Books();
    private ResorceManager manager = ResorceManager.INSTANCE;
    private BooksDAO dbManager;

    public ServiceBooks(){
//        model.setBooks(DataSource.getBooks());
//        model.setBooks(InputOutputFile.load());
        dbManager = new BooksDAO();
        model.setBooks(dbManager.getAll());
    }

    public String showAllBooks() {
        return convertBooksInString(model.getBooks());
    }

    private String convertBooksInString(Book[] books) {
        StringBuilder str = new StringBuilder();
        for (Book book : books) {
            if(book == null)break;
            str.append(book);
            str.append("\n");
        }
        return str.toString();
    }

    public String searchBooksByAuthor(String author) throws SQLException {
        //Book[] books = model.getByAuthor(author);
        Book[] books = dbManager.findByParameter(SQLStatementsBook.getSELECTQueryByAuthor(),author);
        if (books[0] == null) {
            return manager.getMessage("noBooks") + author;
        }
        return manager.getMessage("booksWithAuthor") + author + "\n"
                + convertBooksInString(books);
    }

    public String searchBooksByPublisher(String publisher){
        //Book[] books = model.getByPublisher(publisher);
        Book[] books = dbManager.findByParameter(SQLStatementsBook.getSELECTQueryByPublish(), publisher);
        if (books[0] == null) {
            return manager.getMessage("noBooks") + publisher;
        }
        return manager.getMessage("booksWithPublisher") + publisher
                + "\n" + convertBooksInString(books);
    }

    public String searchBooksAfterYear(int year){
        //Book[] books = model.getAfterYear(year);
        Book[] books = dbManager.findByParameter(SQLStatementsBook.getSELECTQueryByYear(), String.valueOf(year));
        if (books[0] == null) {
            return manager.getMessage("noBooksAfterYear") + year;
        }
        return manager.getMessage("booksAfterYear")+ year + "\n"
                + convertBooksInString(books);
    }

    public String sortByPublisher() {
        //Book[] books = model.getBooks();
        Book[] books = dbManager.getAll();
        Arrays.sort(books, Comparator.comparing(Book::getPublish));
        return convertBooksInString(books);
    }

    public void changeLanguage(int input){
        Language[] languages = Language.values();
        Locale locale = languages[input - 1].getLocale();
        manager.changeLocale(locale);
    }

    public void saveBooks() {
        InputOutputFile.save(model.getBooks());
        dbManager.closeConnection();
    }

    public boolean addBook(BookView view, ResorceManager manager){
        String author = InputUtility.getStringDataForBook(view, manager, "enterAuthor");
        int pages = InputUtility.getIntDataForBook(view, manager, "enterPages");
        double price = InputUtility.getDoubleDatForBook(view, manager, "enterCost");
        String publish = InputUtility.getStringDataForBook(view, manager, "enterPublish");
        String title2 = InputUtility.getStringDataForBook(view, manager, "enterTitle");
        int year = InputUtility.getIntDataForBook(view, manager, "enterYear");
        boolean flag = dbManager.add(author, pages, price, publish, title2, year);
        model.addBook(new Book(author, title2, publish, year, pages, price));
        //model.updateAddedBooks(new Book(title2, author, publish, year, pages, price));
        return flag;
    }

    public boolean deleteBook(BookView view, ResorceManager manager){
        String title = InputUtility.getStringDataForBook(view, manager, "enterTitle");
        boolean flag = dbManager.delete(title);
        model.deleteBook(dbManager.getAll());
        return flag;
    }
}
