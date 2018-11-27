package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public interface Command {
    void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager);
}
