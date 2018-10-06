package com.tg.MatrixController;

import com.tg.MatrixModel.MatrixModel;
import com.tg.MatrixView.MatrixView;

public class MatrixController {
    private MatrixModel model = new MatrixModel();
    private MatrixView view = new MatrixView();

    public MatrixController(MatrixModel model, MatrixView view){
        this.model = model;
        this.view = view;
    }
    public void runMatrix(){
        view.printMessage(view.INPUT_SIZE);
        model.setSize();
        view.showMatrix(view.MATRIX,model.createMatrix());
        view.showMatrix(view.REVERTED_MATRIX, model.revertMatrix());
    }

}
