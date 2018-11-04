package controller;

import com.sun.imageio.plugins.common.I18N;
import data.DataSource;
import jdk.internal.util.xml.impl.Input;
import model.Dictionary;
import services.InputUtility;
import services.Translator;
import view.OutputMessages;
import view.View;

public class Controller {

    private View view;
    private Dictionary model;

    public Controller(View view, Dictionary model){
        this.view = view;
        this.model = model;
    }

    public void run(){
        model.setDictionary(DataSource.getDictionary());
        View.printMessage(OutputMessages.MENU);
        String input;
       do{
           View.printMessage(OutputMessages.WHAT_TO_DO);
           input = InputUtility.getInput();
           Implementation.implement(input, model);
       } while (!input.equals("4"));
    }
}
