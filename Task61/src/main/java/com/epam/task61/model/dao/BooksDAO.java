package com.epam.task61.model.dao;


import com.epam.task61.model.entity.Book;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksDAO <T extends Book> extends AbstractDAO  {

    private Book[] books;
    private int lastInsertedId;
    private BookConnection connector;


    public BooksDAO()  {
            this.connector = new BookConnection();
    }

    @Override
    public T[] getAll() {
        try(Statement st = connector.getStatement()){
            ResultSet result = st.executeQuery(SQLStatementsBook.getAllBooksQuery());
            int sizeOfArray = countAllRows();
            books = parseData(result, sizeOfArray);

        } catch (SQLException e) {
            ResorceManager manager = ResorceManager.INSTANCE;
            new BookView().printMessage(manager.getMessage("errorConnection")+'\n'+manager.getMessage("tryAgainLater"));
        }

        return (T[])books;
    }

    private Book setBook(ResultSet result) throws SQLException{
        Book tempBook = new Book();
        tempBook.setTitul(result.getString(2));
        tempBook.setAuthor(result.getString(3));
        tempBook.setPublish(result.getString(4));
        tempBook.setYear(result.getInt(5));
        tempBook.setPages(result.getInt(6));
        tempBook.setPrice(result.getDouble(7));
        return tempBook;
    }

    private int countAllRows() {
        int amount = 0;
        try (Statement st = connector.getStatement()){
            ResultSet resultSet = st.executeQuery(SQLStatementsBook.getAllBooksQuery());
            amount = resultSet.last() ? resultSet.getRow() : 0;
            lastInsertedId = resultSet.last() ? resultSet.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amount;
    }

    @Override
    public boolean delete(String parameter) {
        boolean flag = false;
        try(PreparedStatement statement = connector.getPreparedStatement(SQLStatementsBook.deleteBookByTitleQuery())){
            statement.setString(1, parameter);
            int result = statement.executeUpdate();
            if(result != 0) flag = true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(String parameter) {
        return false;
    }

    @Override
    public Book[] findByParameter(String statement,String value) {
        Book[] books = null;
        try (PreparedStatement ps = connector.getPreparedStatement(statement)) {
            ps.setString(1, value);
            ResultSet result = ps.executeQuery();
            int size = countAllRows();
            books = parseData(result, size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book[] parseData(ResultSet result, int size) throws SQLException{
        Book[] tempResult = new Book[size];
        int counter = 0;
        while(result.next()){
            Book book = setBook(result);
            tempResult[counter++] = book;
        }
        return tempResult;
    }

    @Override
    public <T> boolean add(T... values) {
        boolean flag = false;
        try(PreparedStatement ps = connector.getPreparedStatement(SQLStatementsBook.getINSERTQuery());){
            ps.setInt(1, lastInsertedId+1);
            ps.setString(2, (String)values[0]);
            ps.setInt(3, (Integer) values[1]);
            ps.setDouble(4, (Double) values[2]);
            ps.setString(5, (String)values[3]);
            ps.setString(6, (String)values[4]);
            ps.setInt(7,(Integer) values[5]);
            int result = ps.executeUpdate();
            if(result !=0 ) flag = true;

        } catch (SQLException e) {
            System.out.println("Can not add book");
            e.printStackTrace();
        }
        return flag;
    }

    public void closeConnection(){
        connector.closeConnection();
    }

}
