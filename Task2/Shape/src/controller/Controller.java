package controller;

import data.DataSource;
import model.Shapes;
import model.entity.Shape;
import view.InputUtility;
import view.ShapesView;

public class Controller {
    Shapes model = new Shapes();
    ShapesView view = new ShapesView();

    public Controller(Shapes model, ShapesView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        model.setShapes(DataSource.getShapes());
        view.printShapes(model.getShapes());
        view.printMessage(ShapesView.MENU);
        String input;
        do {
            input = InputUtility.getString(ShapesView.WHAT_TO_DO);
            WhatToDO.executeBy(input, model);
        } while(!(input.equalsIgnoreCase("exit")));

    }
}
