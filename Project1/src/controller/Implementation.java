package controller;

import data.ListOfIngredients;
import model.Menu;
import model.Salad;
import services.Finder;
import services.InputUtility;
import services.Sorter;
import view.CookView;
import view.OutputMessages;



public class Implementation {
    private static CookView view = new CookView();


    public static void implement(String input, Menu menu){
        if(input.equals("1")){
            view.printSalads(menu.getSalads());
        } else if(input.equals("2")){
            view.printMessage(ListOfIngredients.getListOfIngredients());
        } else if(input.equals("3")){
            view.printMessage(OutputMessages.ENTER_NAME_OF_SALAD);
            String name = InputUtility.setNameOfSalad();
            Salad salad = new Salad(name);
            salad.setIngredients(InputUtility.setSaladIngredients());
            menu.addSalad(salad);
        } else if(input.equals("4")){
            view.printMessage(OutputMessages.ENTER_NAME_OF_SALAD);
            String name = InputUtility.setNameOfSalad();
            menu.deleteSalad(name);

        } else if(input.equals("5")){
            view.printMessage(OutputMessages.ENTER_NAME_OF_SALAD);
            String name = InputUtility.setNameOfSalad();
            view.printMessage(new Finder().findVegetables(menu, name));
        } else if(input.equals("6")){
            view.printMessage(OutputMessages.MIN_RANGE);
            int min = InputUtility.getInt();
            view.printMessage(OutputMessages.MAX_RANGE);
            int max = InputUtility.getInt();
            view.printSalads(new Finder().findFromMenuByCalories(min, max, menu));
        } else if(input.equals("7")){
            view.printSortedSalads(new Sorter().sortByName(menu));
        }
    }

}

