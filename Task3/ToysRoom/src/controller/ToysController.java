package controller;

import data.DataSource;
import model.ToysRoom;
import model.entity.Toy;
import service.SearchUtility;
import view.InputUtility;
import view.ToysView;


public class ToysController {
    //private ToysRoom model;
    private ToysView view;
    private SearchUtility search;

    public ToysController(ToysView view){
        this.view = view;
        ToysRoom model = new ToysRoom<>();
        model.setToys(DataSource.getToys());
        search = new SearchUtility(model);
    }

    public void run(){
        Toy[] temp = DataSource.getToys();
        view.printToys(temp);
        ToysView.printMessage(ToysView.MENU);
        int input;
        do{
            input = InputUtility.getInt(ToysView.WHAT_TO_DO);
            new WhatToDo().getResult(input, search);
        } while(input != 6);
    }
}
