package controller;

import model.Menu;
import model.entity.Tomato;
import services.InputUtility;
import view.CookView;
import view.OutputMessages;


public class CookController {

    private CookView view;
    private Menu menu;

    public CookController(CookView view, Menu menu){
        this.view = view;
        this.menu = menu;
    }

    public void run(){
        view.printMessage(OutputMessages.MENU);
        String input;
        do{
            view.printMessage(OutputMessages.WHAT_TO_DO);
            input = InputUtility.getInput();
            Implementetion.implement(input, menu);
        } while(!input.equals("0"));
    }
}
