package com.epam.task61.util;

import com.epam.task61.view.BookView;
import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(BookView view, ResorceManager manager) {
        view.printMessage(manager.getMessage("INPUT_INT_DATA"));
        while (!sc.hasNextInt()) {
            view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_INT_DATA"));
            sc.next();
        }
        return sc.nextInt();
    }

    public static String inputString(BookView view, ResorceManager manager) {
        while (true) {
            view.printMessage(manager.getMessage("INPUT_STRING_DATA"));
            String text = sc.next();
            if ( Validator.isCorrectString(text)) {
                return text;
            }
            view.printError(manager.getMessage("WRONG_INPUT_DATA"));
        }
    }

    public static Double inputDouble(BookView view, ResorceManager manager){
        view.printMessage(manager.getMessage("INPUT_INT_DATA"));
        while (!sc.hasNextDouble()) {
            view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_INT_DATA"));
            sc.next();
        }
        return sc.nextDouble();
    }

    public static String getStringDataForBook(BookView view, ResorceManager manager, String key){
        while (true) {
            view.printMessage(manager.getMessage(key));
            String text = sc.next();
            if ( Validator.isCorrectString(text)) {
                return text;
            }
            view.printError(manager.getMessage("WRONG_INPUT_DATA"));
        }

    }

    public static int getIntDataForBook(BookView view, ResorceManager manager, String key){
        view.printMessage(manager.getMessage(key));
        while (!sc.hasNextInt()) {
            view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_INT_DATA"));
            sc.next();
        }
        return sc.nextInt();
    }

    public static double getDoubleDatForBook(BookView view, ResorceManager manager, String key){
        view.printMessage(manager.getMessage(key));
        while (!sc.hasNextDouble()) {
            view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_INT_DATA"));
            sc.next();
        }
        return sc.nextDouble();
    }

}
