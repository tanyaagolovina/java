package com.tg.MatrixController;

import com.tg.MatrixModel.MatrixModel;
import com.tg.MatrixView.MatrixView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixController {
    private MatrixModel model = new MatrixModel();
    private MatrixView view = new MatrixView();

    public MatrixController(MatrixModel model, MatrixView view){
        this.model = model;
        this.view = view;
    }
    public void runMatrix(){
        view.printMessage(MatrixView.INPUT_SIZE);
        int tempSize = setSize();
        view.showMatrix(MatrixView.MATRIX, model.createMatrix(tempSize));
        view.showMatrix(MatrixView.REVERTED_MATRIX, model.revertMatrix());
    }
    private int setSize(){
        try {
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            return checkNumber(size);
        } catch (InputMismatchException e) {
            view.printMessage(MatrixView.ERROR_NAN);
            return setSize();
        }
    }
    private int checkNumber(int number){
        if(number <= 0) {
            view.printMessage(MatrixView.ERROR);
            return setSize();
        } else {
            return number;
        }
    }

}
