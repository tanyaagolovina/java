package com.epam.task61.controller;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;
import sun.net.ResourceManager;

public class Controller {
    private ServiceBooks serviceBooks = new ServiceBooks();
    private BookView view = new BookView();
    ResorceManager manager = ResorceManager.INSTANCE;

    public void run() {
        while (true) {
            view.printMessage(manager.getMessage("mainMenu"));
            int number = InputUtility.inputInt(view, manager);
            Macros macros = new Macros(number);
            macros.execute(view, serviceBooks, manager);
        }
    }
}
