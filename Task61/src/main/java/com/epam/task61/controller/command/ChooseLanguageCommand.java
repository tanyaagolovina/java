package com.epam.task61.controller.command;

import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

public class ChooseLanguageCommand implements Command {
    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) {
        view.printMessage(resorceManager.getMessage("language"));
        serviceBooks.changeLanguage(InputUtility.inputInt(view, resorceManager));
    }
}
