package com.epam.task61.view;

import com.epam.task61.model.entity.Book;

public class BookView {
    /*public static final String MAIN_MENU=" 1. Show all books\" +\n" +
            "            \"\\n 2. Find by author\" +\n" +
            "            \"\\n 3. Find by publisher\" +\n" +
            "            \"\\n 4. Find books published after specified year\" +\n" +
            "            \"\\n 5. Sort books by publisher \" +\n" +
            "            \"\\n 0. Exit ";
    public static final String ALL_BOOKS="All books :";
    public static final String INPUT_INT_DATA="Choise operation :";
    public static final String INPUT_STRING_DATA="Enter string :";
    public static final String WRONG_INPUT_DATA ="Incorrect input.";
    public static final String SORRTED_BOOKS ="Sorted books by publisher: ";*/

     public void printMessage(String s) {
        System.out.println(s);
    }

    public void printError(String str) {
        System.err.println(str);
    }
}
