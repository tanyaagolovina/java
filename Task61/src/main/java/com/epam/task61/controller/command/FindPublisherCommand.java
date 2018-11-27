package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public class FindPublisherCommand implements Command{
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        view.printMessage(serviceBooks.searchBooksByPublisher(InputUtility.inputString(view, resorceManager)));
    }
}
