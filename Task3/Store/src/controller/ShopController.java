package controller;

import model.StoreModel;
import view.InputUtility;
import view.OutputMessages;
import view.StoreView;

public class StoreController {

    private StoreModel model;
    private StoreView view;

    public StoreController(StoreModel model, StoreView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        StoreView.printMessage(OutputMessages.MENU);
        int input;
        do{
            StoreView.printMessage(OutputMessages.WHAT_TO_DO);
            input = new InputUtility().getInt();
            WhatToDo.executeBy(input, model);
        } while(input != 0);
    }
}
