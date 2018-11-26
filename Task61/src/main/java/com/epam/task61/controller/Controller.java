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
            ItemMenu command = defineMenuItem(number);
            switch (command) {
                case SHOW_BOOKS:
                    view.printMessage(manager.getMessage("listBooks"));
                    view.printMessage(serviceBooks.showAllBooks());
                    break;
                case FIND_AUTHOR:
                    view.printMessage(serviceBooks.searchBooksByAuthor(InputUtility.inputString(view, manager)));
                    break;
                case FIND_PUBLISH:
                    view.printMessage(serviceBooks.searchBooksByPublisher(InputUtility.inputString(view, manager)));
                    break;
                case FIND_YEAR:
                    view.printMessage(serviceBooks.searchBooksAfterYear(InputUtility.inputInt(view, manager)));
                    break;
                case SORT_PUBLISH:
                    view.printMessage(manager.getMessage("SORTED_BOOKS"));
                    view.printMessage(serviceBooks.sortByPublisher());
                    break;
                case LANGUAGE:
                    view.printMessage(manager.getMessage("language"));
                    serviceBooks.changeLanguage(InputUtility.inputInt(view, manager));
                    break;
                case EXIT:
                    serviceBooks.saveBooks();
                    System.exit(0);
                    break;
                default:
                    view.printMessage(manager.getMessage("WRONG_INPUT_DATA"));
            }
        }
    }

    private ItemMenu defineMenuItem(int number) {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            return ItemMenu.DEFAULT;
        }
        return itemMenus[number];
    }
}
