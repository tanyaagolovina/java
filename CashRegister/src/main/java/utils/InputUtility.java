package utils;

import java.util.Scanner;

public class InputUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        while (!scanner.hasNextInt()) {
            //view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_INT_DATA"));
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String getString(){
        return scanner.nextLine();
    }

    public static double getDouble(){
        while (!scanner.hasNextDouble()) {
            //view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_INT_DATA"));
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
