package com.tg.AbsoluteNumbersController;

import com.tg.AbsoluteNumbersView.AbsoluteNumbersView;
import com.tg.AbsoluteNumbersModel.AbsoluteNumbersModel;
import com.tg.AbsoluteNumbersView.InputUtility;
import com.tg.AbsoluteNumbersView.OutputMessages;


public class AbsoluteNumbersController {
    private AbsoluteNumbersModel model;
    private AbsoluteNumbersView view;

    public AbsoluteNumbersController(AbsoluteNumbersModel model, AbsoluteNumbersView view){
        this.model = model;
        this.view = view;
    }
    public void findNumbers(){
        view.printMessage(OutputMessages.INPUT_VALUE);
        view.printResult(OutputMessages.RESULT, model.findNumbers(InputUtility.getInt()));
    }
    /*private int setRange(){
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        if(range <= 0) {
            view.printMessage(view.ERROR);
            return setRange();
        } else {
            return range;
        }

    }*/
}
