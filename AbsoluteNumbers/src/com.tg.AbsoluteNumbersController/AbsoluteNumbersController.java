package com.tg.AbsoluteNumbersController;

import com.tg.AbsoluteNumbersView.AbsoluteNumbersView;
import com.tg.AbsoluteNumbersModel.AbsoluteNumbersModel;

public class AbsoluteNumbersController {
    private AbsoluteNumbersModel model;
    private AbsoluteNumbersView view;

    public AbsoluteNumbersController(AbsoluteNumbersModel model, AbsoluteNumbersView view){
        this.model = model;
        this.view = view;
    }
    public void findNumbers(){
        view.printMessage(view.INPUT_VALUE);
        model.setRange();
        view.printResult(view.RESULT, model.findNumbers());
    }

}
