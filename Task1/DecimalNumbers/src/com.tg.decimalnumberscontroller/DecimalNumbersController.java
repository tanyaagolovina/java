package com.tg.decimalnumberscontroller;
import com.tg.decimalnumbersmodel.DecimalNumbersModel;
import com.tg.decimalnumbersview.DecimalNumbersView;
import com.tg.decimalnumbersview.InputUtility;
import com.tg.decimalnumbersview.OutputMessages;

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
        view.printMessage(OutputMessages.INPUT_INT);
        int tempNumber = setNumber();
        view.printMessage(OutputMessages.SYSTEM);
        int tempSystem = setSystem();
        model.translateNumber(tempNumber,tempSystem);
        view.printResult(OutputMessages.RESULT, model.getRevertedNumber());
    }
    private int setNumber(){
        return checkNumber(InputUtility.getInt());
        /*try{
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            return checkNumber(number);
        } catch (InputMismatchException e) {
            view.printMessage(OutputMessages.ERROR_NAN);
            return setNumber();*/
        }

    private int setSystem(){
            int system = InputUtility.getInt();
            return checkSystem(system);
        }

    private int checkSystem(int system){
        if(system == 2 || system == 8 || system == 16){
            return system;
        } else {
            view.printMessage(OutputMessages.ERROR_SYSTEM);
            return setSystem();
        }
    }

    private int checkNumber(int number){
        if (number <= 0) {
            view.printMessage(OutputMessages.ERROR);
            return setNumber();
        } else {
            return number;
        }
    }
}
