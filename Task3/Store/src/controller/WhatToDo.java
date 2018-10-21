package controller;

import model.StoreModel;
import view.InputUtility;
import view.OutputMessages;
import view.StoreView;

public class WhatToDo {

    public static void executeBy(int term, StoreModel model){
        if(term == 1) {
            new StoreView().printDepartments(model.getDepartments());
        } else if(term == 2) {
            StoreView.printMessage(OutputMessages.NAME);
            String name = new InputUtility().getString();
            StoreView.printMessage(OutputMessages.LOCATION);
            String location = new InputUtility().getString();
            model.addDepartment(name, location);
            new StoreView().printDepartments(model.getDepartments());
        } else if(term == 3){
            StoreView.printMessage(OutputMessages.NAME);
            String name = new InputUtility().getString();
            model.deleteDepartment(name);
        } else if(term == 4){
            model.sortDepartments();
            new StoreView().printDepartments(model.getDepartments());
        }
    }

}
