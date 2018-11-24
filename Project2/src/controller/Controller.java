package controller;

import controller.command.Macros;
import model.Sentence;
import model.Text;
import services.FileReader;
import services.InputUtility;
import view.OutputMessages;
import view.View;

import java.util.ArrayList;


public class Controller {

    private View view;
    private Text text;

    public Controller(View view, Text text){
        this.view = view;
        this.text = text;
    }

    public void run() {
        view.printMessage(OutputMessages.MENU);
        text = new Text(new FileReader().readText());
        text.textToArray();
        int input;
        Macros macros;
        do{
            view.printMessage(OutputMessages.ENTER_INT);
            input = InputUtility.getInt();
            macros = new Macros(input);
            macros.execute(text);
        } while(input!=4);
    }
}
