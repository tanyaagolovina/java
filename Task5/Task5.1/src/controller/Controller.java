package controller;

import model.Students;
import services.InputUtility;
import view.OutputMessages;
import view.View;

public class Controller {

    private Students model;

    public Controller(Students model){
        this.model = model;
    }

    public void run(){
        View.printMessage(OutputMessages.MENU);
        String input;
        do{
            View.printMessage(OutputMessages.WHAT_TO_DO);
            input = InputUtility.getInput();
            WhatToDo.execute(input, model);

        } while (!input.equals("3"));

    }
}
