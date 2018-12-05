package com.epam.task61.model.dao;

public class SQLStatementsBook {

    public static String getAllBooksQuery(){
        return "SELECT * FROM books";
    }

    public static String deleteBookByTitleQuery(){
        return "DELETE FROM books WHERE titlel = ?";
    }

    public static String getUPDATEQuery(){
        return null;
    }

    public static String getINSERTQuery(){
        return "INSERT INTO books (idbooks, author, pages, price, publish, titlel, year) VALUES (?,?,?,?,?,?,?)";
    }

    public static String getSELECTQueryByAuthor(){
        return "SELECT * FROM books WHERE author = ?";
    }

    public static String getSELECTQueryByPublish(){
        return "SELECT * FROM books WHERE publish = ?";
    }

    public static String getSELECTQueryByYear(){
        return "SELECT * FROM books WHERE year > ?";
    }

}
