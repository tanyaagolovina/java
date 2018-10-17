package com.tg.AbsoluteNumbersController;

import com.tg.AbsoluteNumbersView.AbsoluteNumbersView;
import com.tg.AbsoluteNumbersModel.AbsoluteNumbersModel;

import java.util.Scanner;

public class AbsoluteNumbersController {
    private AbsoluteNumbersModel model;
    private AbsoluteNumbersView view;

    public AbsoluteNumbersController(AbsoluteNumbersModel model, AbsoluteNumbersView view){
        this.model = model;
        this.view = view;
    }
    public void findNumbers(){
        view.printMessage(view.INPUT_VALUE);
        view.printResult(view.RESULT, model.findNumbers(setRange()));
    }
    private int setRange(){
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        if(range <= 0) {
            view.printMessage(view.ERROR);
            return setRange();
        } else {
            return range;
        }

    }
}
