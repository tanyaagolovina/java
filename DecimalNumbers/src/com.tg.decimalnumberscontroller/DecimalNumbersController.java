package com.tg.decimalnumberscontroller;
import com.tg.decimalnumbersmodel.DecimalNumbersModel;
import com.tg.decimalnumbersview.DecimalNumbersView;

import java.util.InputMismatchException;
import java.util.Scanner;


public class DecimalNumbersController {
    private DecimalNumbersModel model;
    private DecimalNumbersView view;

    public DecimalNumbersController(DecimalNumbersModel model,DecimalNumbersView view) {
        this.model = model;
        this.view = view;
    }
    public void translate(){
        view.printMessage(view.INPUT_INT);
        int tempNumber = setNumber();
        view.printMessage(view.SYSTEM);
        int tempSystem = setSystem();
        model.translateNumber(tempNumber,tempSystem);
        model.revert();
        view.printResult(view.RESULT, model.getRevertedNumber());
    }
    private int setNumber(){
        try{
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            return checkNumber(number);
        } catch (InputMismatchException e) {
            view.printMessage(DecimalNumbersView.ERROR_NAN);
            return setNumber();
        }

    }
    private int setSystem(){
        try{
            Scanner in = new Scanner(System.in);
            int system = in.nextInt();
            return checkSystem(system);
        } catch (InputMismatchException e) {
            view.printMessage(DecimalNumbersView.ERROR_NAN);
            return setSystem();
        }


    }
    private int checkSystem(int system){
        if(system == 2 || system == 8 || system == 16){
            return system;
        } else {
            view.printMessage(view.ERROR_SYSTEM);
            return setSystem();
        }
    }
    private int checkNumber(int number){
        if (number <= 0) {
            view.printMessage(view.ERROR);
            return setNumber();
        } else {
            return number;
        }
    }
}
