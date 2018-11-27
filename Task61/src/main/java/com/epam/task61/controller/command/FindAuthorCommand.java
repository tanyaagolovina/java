package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public class FindAuthorCommand implements Command {
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        view.printMessage(serviceBooks.searchBooksByAuthor(InputUtility.inputString(view, resorceManager)));
    }
}
