package com.epam.task61.controller;

import com.epam.task61.model.dao.BooksDAO;
import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.util.exception.SQLConnectionError;
import com.epam.task61.view.BookView;
import jdk.internal.util.xml.impl.Input;

import java.sql.SQLException;


public class Controller {
    private ServiceBooks serviceBooks;
    private BookView view = new BookView();
    ResorceManager manager = ResorceManager.INSTANCE;

    public Controller()  {
     serviceBooks = new ServiceBooks();
    }

    public void run() {

        while (true) {
            view.printMessage(manager.getMessage("mainMenu"));
            int number = InputUtility.inputInt(view, manager);
            Macros macros = new Macros(number);
            try{
                macros.execute(view, serviceBooks, manager);
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }
}
