package com.epam.task61.controller;

import com.epam.task61.controller.command.*;

public enum ItemMenu {
    EXIT(new ExitCommand()),
    SHOW_BOOKS(new ShowBooksCommand()),
    FIND_AUTHOR(new FindAuthorCommand()),
    FIND_PUBLISH(new FindPublisherCommand()),
    FIND_YEAR(new FindYearCommand()),
    SORT_PUBLISH(new SortPublisherCommand()),
    LANGUAGE(new ChooseLanguageCommand()),
    ADD_BOOK(new AddBookCommand()),
    DELETE_BOOK(new DeleteBookCommand()),
    DEFAULT(new DefaultCommand());
    private Command command;
    ItemMenu(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
