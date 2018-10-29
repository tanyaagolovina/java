package services;

import model.entity.*;
import view.CookView;
import view.OutputMessages;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputUtility {

    private static Scanner in = new Scanner(System.in);
    private static String input;

    public static String setNameOfSalad(){
        input = in.nextLine();
        while(!Validator.isValidSaladName(input)) {
            CookView.printMessage(OutputMessages.WRONG_SALAD_NAME);
            input = in.nextLine();
        }
        return input;
    }

    public static int getInt(){
        while(!(in.hasNextInt())){
            CookView.printMessage(OutputMessages.ERROR);
            in.next();
        }
        return in.nextInt();
    }

    private static String getIngredient(){
        input = in.nextLine();
        while(!Validator.isValidIngredient(input)){
            CookView.printMessage(OutputMessages.DOES_NOT_EXIST);
            input = in.nextLine();
        }
        return input;
    }

    public static String getInput(){
        input = in.nextLine();
        while(!Validator.isValidInput(input)) {
            CookView.printMessage(OutputMessages.ERROR);
            input = in.nextLine();
        }
        return input;
    }

    private static String getAmountOfIngredients(){
        input = in.nextLine();
        while(!Validator.isValidAmountOfIngredients(input)){
            CookView.printMessage(OutputMessages.WRONG_AMOUNT);
            input = in.nextLine();
        }
        return input;
    }

    public static ArrayList<Vegetable> setSaladIngredients(){
        CookView.printMessage(OutputMessages.ENTER_AMOUNT_OF_INGREDIENTS);
        int amountOfIngredients = parseInt(getAmountOfIngredients());
        ArrayList<Vegetable> salad = new ArrayList<>();
        for(int ingredient = 0; ingredient < amountOfIngredients; ingredient++){
            CookView.printMessage(OutputMessages.ENTER_INGREDIENT);
            CookView.printMessage(OutputMessages.INGREDIENT + (ingredient+1) + " - ");
            salad.add(defineIngredient(getIngredient()));
        }
        return salad;
    }

    private static Vegetable defineIngredient(String ingredient) {
        if (ingredient.equalsIgnoreCase("broccoli")) {
            Vegetable veg = new Broccoli();
            return veg;
        } else if (ingredient.equalsIgnoreCase("corn")) {
            Vegetable veg = new Corn();
            return veg;
        } else if (ingredient.equalsIgnoreCase("cucumber")) {
            Vegetable veg = new Cucumber();
            return veg;
        } else if (ingredient.equalsIgnoreCase("lettuce")) {
            Vegetable veg = new Lettuce();
            return veg;
        } else if (ingredient.equalsIgnoreCase("onion")) {
            Vegetable veg = new Onion();
            return veg;
        } else if (ingredient.equalsIgnoreCase("paprika")) {
            Vegetable veg = new Paprika();
            return veg;
        } else if (ingredient.equalsIgnoreCase("tomato")) {
            Vegetable veg = new Tomato();
            return veg;
        } else return null;
    }
}
