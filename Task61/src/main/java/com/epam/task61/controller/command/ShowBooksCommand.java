package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public class ShowBooksCommand implements Command {
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        view.printMessage(resorceManager.getMessage("listBooks"));
        view.printMessage(serviceBooks.showAllBooks());
    }
}
