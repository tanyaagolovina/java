package controller;

import data.DataSource;
import model.entity.Book;
import model.entity.model.Books;
import view.BooksView;

import java.util.Scanner;

public class Controller {
    private Books model = new Books();
    private BooksView view = new BooksView();


    public void run(){
        introduction();
        model.setBooks(DataSource.getBooks());
        String searchTerms;
        view.printBooks(view.ALL_BOOKS, model.getBooks());
        do {
            searchTerms = getInput(view.INPUT_WHAT_TO_DO);
            findBy(searchTerms);
        } while (!(searchTerms.equalsIgnoreCase("exit")));

    }
    private void printResult(String searchTerms, Book[] books){
        if(books.length == 0 ){
            view.printMessage("Nothing had founded. Please verify the spelling and try one more time.");
        } else {
            view.printBooks("Search by " + searchTerms, books);
        }
    }
    private String getInput(String message){
        String input;
        view.printMessage(message);
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        return input.trim();
    }
    private void introduction(){
       view.printMessage("This is library. What can you do?");
       view.printMessage("1.Find books by author(enter - author)");
       view.printMessage("2.Find books by publisher(enter - publisher)");
       view.printMessage("3.Find books by year. As result you'll see all books written after this year(enter - year)");
       view.printMessage("4.Order all books by publisher(enter - order)");
       view.printMessage("5.Exit(enter - exit)");
    }
    private void findBy(String searchTerms){
        String temp;
        Book [] result;
        if(searchTerms.equalsIgnoreCase("author")){
            temp = getInput(view.ENTER_AUTHOR);
            result = model.findByAuthor(temp);
            printResult(searchTerms, result);
        } else if(searchTerms.equalsIgnoreCase("publisher")){
            temp = getInput(view.ENTER_PUBLISHER);
            result = model.findByPublisher(temp);
            printResult(searchTerms, result);
        } else if(searchTerms.equalsIgnoreCase("year")){
            temp = getInput(view.ENTER_YEAR);
            result = model.findByYear(checkAndGetYear(temp));
            printResult(searchTerms, result);
        } else if (searchTerms.equalsIgnoreCase("order")) {
            result = model.orderByPublisher();
            printResult(searchTerms, result);
        } else if (!(searchTerms.equalsIgnoreCase("exit"))){
            view.printMessage(view.ERROR);
        }
    }
    private String checkAndGetYear(String yearStr){
        if(yearStr.matches("[\\d]+")) {
            return yearStr;
        } else {
            view.printMessage(view.ERROR_NAN);
            return getInput(view.ENTER_YEAR);
        }
    }
}