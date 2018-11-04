package services;

import view.OutputMessages;
import view.View;

import java.util.Scanner;

public class InputUtility {

    private static String input;

    private static Scanner scanner = new Scanner(System.in);

    public static String getInput(){
        input = scanner.nextLine();
        if(!Validator.isValidInput(input)) {
            View.printMessage(OutputMessages.ERROR);
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getTranslate(){
        input = scanner.nextLine();
        return input;
    }

    public static String getWord(){
        input = scanner.nextLine();
        if(!Validator.isValidWord(input)) {
            View.printMessage(OutputMessages.ERROR);
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getLine(){
        input = scanner.nextLine();
        if(!Validator.isValidLine(input)) {
            View.printMessage(OutputMessages.ERROR);
            input = scanner.nextLine();
        }
        return input;
    }
}
