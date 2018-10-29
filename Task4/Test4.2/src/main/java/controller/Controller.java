package controller;

import data.DataSource;
import model.entity.Book;
import model.Books;
import view.BooksView;

import java.util.Scanner;

public class Controller {
    private Books model = new Books();
    private BooksView view = new BooksView();


    public void run(){
        view.printMessage(BooksView.INTRO);
        model.setBooks(DataSource.getBooks());
        String searchTerms;
        view.printBooks(BooksView.ALL_BOOKS, model.getBooks());
        do {
            searchTerms = getInput(BooksView.INPUT_WHAT_TO_DO);
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
    private void findBy(String searchTerms){
        String temp;
        Book [] result;
        if(searchTerms.equalsIgnoreCase("author")){
            temp = getInput(BooksView.ENTER_AUTHOR);
            result = model.findByAuthor(temp);
            printResult(searchTerms, result);
        } else if(searchTerms.equalsIgnoreCase("publisher")){
            temp = getInput(BooksView.ENTER_PUBLISHER);
            result = model.findByPublisher(temp);
            printResult(searchTerms, result);
        } else if(searchTerms.equalsIgnoreCase("year")){
            temp = getInput(BooksView.ENTER_YEAR);
            result = model.findByYear(checkAndGetYear(temp));
            printResult(searchTerms, result);
        } else if (searchTerms.equalsIgnoreCase("order")) {
            result = model.orderByPublisher();
            printResult(searchTerms, result);
        } else if (!(searchTerms.equalsIgnoreCase("exit"))){
            view.printMessage(BooksView.ERROR);
        }
    }
    private String checkAndGetYear(String yearStr){
        if(yearStr.matches("[\\d]+")) {
            return yearStr;
        } else {
            view.printMessage(BooksView.ERROR_NAN);
            return getInput(BooksView.ENTER_YEAR);
        }
    }
}

