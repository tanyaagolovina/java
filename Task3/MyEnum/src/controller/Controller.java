package controller;

import model.MyEnum;
import model.entity.Enum;
import model.entity.Food;
import view.View;

public class Controller {
    private MyEnum<Enum> model;
    private View<Enum> view;

    public Controller(MyEnum<Enum> model, View<Enum> view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        model.setEnums(Food.getEnums());
        view.printEnums(model.getEnums());
        view.printOneEnum(model.valueOf("BREAD"));
        view.printMessage(model.getNamesOfEnums());
        view.printMessage(model.valuesOfEnums());
    }
}
