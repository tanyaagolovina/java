package com.tg.PyramidController;

import com.tg.PyramidView.PyramidView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PyramidController {
    private PyramidView view = new PyramidView();

    public PyramidController(PyramidView view){
        this.view = view;
    }
    public void buildPyramid(){
        view.printMessage(PyramidView.INPUT_HEIGHT);
        view.showPyramid(setHeight());
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
