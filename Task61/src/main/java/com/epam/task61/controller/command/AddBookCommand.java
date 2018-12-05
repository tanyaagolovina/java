package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

import java.sql.SQLException;

public class AddBookCommand implements Command{
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) throws SQLException {
        boolean flag = serviceBooks.addBook(view, resorceManager);
        if(flag) view.printMessage(resorceManager.getMessage("bookAdded"));
        else view.printMessage(resorceManager.getMessage("bookWasNotAdded"));
    }
}
