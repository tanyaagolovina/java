package com.epam.task61.controller;

import com.epam.task61.controller.command.Command;
import com.epam.task61.service.ServiceBooks;
import com.epam.task61.util.ResorceManager;
import com.epam.task61.view.BookView;

import java.sql.SQLException;

public class Macros implements Command {

    private int input;

    public Macros(int input){
        this.input = input;
    }

    @Override
    public void execute(BookView view, ServiceBooks serviceBooks, ResorceManager resorceManager) throws SQLException {
        ItemMenu itemMenu = defineMenuItem(input);
        itemMenu.getCommand().execute(view, serviceBooks, resorceManager);
    }

    private ItemMenu defineMenuItem(int number) {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            return ItemMenu.DEFAULT;
        }
        return itemMenus[number];
    }
}
