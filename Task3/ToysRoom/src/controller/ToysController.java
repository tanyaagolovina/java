package controller;

import data.DataSource;
import model.ToysRoom;
import model.entity.Toy;
import view.InputUtility;
import view.ToysView;

public class ToysController {
    private ToysRoom model = new ToysRoom();
    private ToysView view = new ToysView();

    public ToysController(ToysRoom model, ToysView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        Toy[] temp = DataSource.getToys();
        model.setToys(temp);
        view.printToys(model.getToys());
        ToysView.printMessage(ToysView.MENU);
        int input;
        do{
            input = InputUtility.getInt(ToysView.WHAT_TO_DO);
            WhatToDo.executeBy(input, model);
        } while(input != 6);
    }
}
