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
