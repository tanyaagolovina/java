package com.tg.PyramidController;

import com.tg.PyramidView.PyramidView;
import model.PyramidModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PyramidController {
    private PyramidView view;
    private PyramidModel model;

    public PyramidController(PyramidModel model, PyramidView view){
        this.model = model;
        this.view = view;
    }
    public void buildPyramid(){
        view.printMessage(PyramidView.INPUT_HEIGHT);
        model.setHeight(setHeight());
        view.printPyramid(model.getHeight(), model.buildPyramid());
    }
    private int setHeight(){
        try {
            Scanner in = new Scanner(System.in);
            int height = in.nextInt();
            return checkNumber(height);
        } catch (InputMismatchException e){
            view.printMessage(PyramidView.ERROR_NAN);
            return setHeight();
        }
    }
    private int checkNumber(int number){
        if(number <= 0) {
            view.printMessage(PyramidView.ERROR);
            return setHeight();
        } else {
            return number;
        }
    }
}
