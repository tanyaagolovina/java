package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public class ExitCommand implements Command {
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        serviceBooks.saveBooks();
        view.printMessage(resorceManager.getMessage("exit"));
        System.exit(0);
    }
}
