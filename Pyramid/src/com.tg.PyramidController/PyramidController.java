package com.tg.PyramidController;

import com.tg.PyramidModel.PyramidModel;
import com.tg.PyramidView.PyramidView;

public class PyramidController {
    private PyramidModel model = new PyramidModel();
    private PyramidView view = new PyramidView();

    public PyramidController(PyramidModel model, PyramidView view){
        this.model = model;
        this.view = view;
    }
    public void buildPyramid(){
        view.printMessage(view.INPUT_HEIGHT);
        view.showPyramid(model.setHeight());
    }
}
