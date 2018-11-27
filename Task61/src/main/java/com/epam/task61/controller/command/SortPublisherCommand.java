package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public class SortPublisherCommand implements Command {
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        view.printMessage(resorceManager.getMessage("SORTED_BOOKS"));
        view.printMessage(serviceBooks.sortByPublisher());
    }
}
