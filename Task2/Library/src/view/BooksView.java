package view;

import model.entity.Book;

public class BooksView {
    public static String INPUT_WHAT_TO_DO = "What do you want to do?";
    public static String ENTER_AUTHOR = "Enter an author : ";
    public static String ENTER_PUBLISHER = "Enter a publisher : ";
    public static String ENTER_YEAR = "Enter a year : ";
    public static String ERROR = "You have entered a wrong action. Try again!";
    public static String ALL_BOOKS = "All books: ";
    public static String ERROR_NAN = "You can enter only numbers. Try again!";
    public static String INTRO = "This is library. What can you do? \n"  +
            "1.Find books by author(enter - author) \n" +
            "2.Find books by publisher(enter - publisher) \n" +
            "3.Find books by year. As result you'll see all books written after this year(enter - year) \n" +
            "4.Order all books by publisher(enter - order) \n" +
            "5.Exit(enter - exit)"
            ;


    public void printBooks(String message,Book[] books){
        System.out.println(message);
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void printMessage(String message){
        System.out.println(message);
    }
}
