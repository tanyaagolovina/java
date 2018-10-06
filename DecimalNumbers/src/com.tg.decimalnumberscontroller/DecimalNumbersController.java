package com.tg.decimalnumberscontroller;
import com.tg.decimalnumbersmodel.DecimalNumbersModel;
import com.tg.decimalnumbersview.DecimalNumbersView;


public class DecimalNumbersController {
    private DecimalNumbersModel model;
    private DecimalNumbersView view;

    public DecimalNumbersController(DecimalNumbersModel model,DecimalNumbersView view) {
        this.model = model;
        this.view = view;
    }
    public void translate(){
        view.printMessage(view.INPUT_INT);
        model.setNumber();
        view.printMessage(view.SYSTEM);
        model.setSystem();
        model.translateNumber();
        model.revert();
        view.printResult(view.RESULT, model.getRevertedNumber());
    }
}
