package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidIngredient(String ingredient){
        String regular = "(broccoli)||(corn)||(cucumber)||(lettuce)||(onion)||(paprika)||(tomato)";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(ingredient.toLowerCase());
        return matcher.matches();
    }

    public static boolean isValidSaladName(String ingredient){
        String regular = "\\p{Upper}\\w+";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(ingredient);
        return matcher.matches();
    }



    public static boolean isValidInput(String input){
        String regular = "[0-8]";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isValidAmountOfIngredients(String amount){
        String regular = "[1-7]";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(amount);
        return matcher.matches();
    }
}
