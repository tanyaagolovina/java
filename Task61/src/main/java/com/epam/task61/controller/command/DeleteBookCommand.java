package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

import java.sql.SQLException;

public class DeleteBookCommand implements Command {
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        boolean flag = serviceBooks.deleteBook(view, resorceManager);
        if(flag) view.printMessage(resorceManager.getMessage("bookWasDeleted"));
        else view.printMessage(resorceManager.getMessage("doesNotExist"));
    }
}
