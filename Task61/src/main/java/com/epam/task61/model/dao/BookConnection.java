package com.epam.task61.model.dao;

import com.epam.task61.view.BookView;

import java.sql.*;
import java.util.ResourceBundle;

public class BookConnection {
    private static Connection connection;
    private static String url;
    private static String user;
    private static String password;
    private static ResourceBundle resourceBundle;
    private static BookView view = new BookView();

    {
        resourceBundle = ResourceBundle.getBundle("proporties.connection");
    }

    public BookConnection(){
        url = resourceBundle.getString("url");
        //user = "";
        user = resourceBundle.getString("user");
        password = resourceBundle.getString("password");
        try{
            connection = DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            //view.printMessage(resourceBundle.getString("errorConnection") + '\n' + resourceBundle.getString("tryAgainLater"));
            e.printStackTrace();
        }
    }


    public Statement getStatement() throws SQLException{
        if(connection != null) {
            Statement statement = connection.createStatement();
            if(statement != null) {
                return statement;
            }
        }
        throw new SQLException(resourceBundle.getString("errorInConnectionOrStatement"));
    }

    public PreparedStatement getPreparedStatement(String ps) throws SQLException{
        if(connection != null) {
            PreparedStatement statement = connection.prepareStatement(ps);
            if(statement != null) {
                return statement;
            }
        }
        throw new SQLException(resourceBundle.getString("errorInConnectionOrStatement"));
    }

    public void closeStatement(Statement st){
        if(st != null) {
            try{
                st.close();
            } catch (SQLException e) {
                view.printMessage(resourceBundle.getString("errorInClosingStatement" + e));
            }
        }
    }

    public void closeConnection(){
        if(connection != null) {
            try{
                connection.close();
            } catch (SQLException e) {
                view.printMessage(resourceBundle.getString("errorInClosingConnection") + e);
            }
        }
    }
}
