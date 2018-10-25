package services;

import view.OutputMessages;
import view.View;

import java.util.Scanner;

public class InputUtility {
    private static Scanner in = new Scanner(System.in);

    public static String getName(){
        String name;
        name = in.nextLine().trim();
        while(!Validator.isValidName(name)){
            View.printMessage(OutputMessages.ERROR);
            name = in.nextLine().trim();
        }
        return name;
    }



    public static String getPhone(){
        String number = in.nextLine().trim();
        while(!Validator.isValidPhoneNumber(number)) {
            View.printMessage(OutputMessages.ERROR);
            number = in.nextLine().trim();
        }
        return number;
    }

    public static String getInput(){
        String input = in.nextLine();
        while(!Validator.isValidInput(input)) {
            View.printMessage(OutputMessages.ERROR);
            input = in.nextLine();
        }
        return input;
    }

    public static String getAddress(){
        String address = in.nextLine().trim();
        while(!Validator.isValidAddress(address)) {
            View.printMessage(OutputMessages.ERROR);
            address = in.nextLine().trim();
        }
        return address;
    }

    public static String getDateOfBirth(){
        String date = in.nextLine().trim();
        while(!Validator.isValidDateOfBirth(date)) {
            View.printMessage(OutputMessages.ERROR);
            date = in.nextLine().trim();
        }
        return date;
    }
}
