package services;

import view.OutputMessages;
import view.View;

import java.util.Scanner;

public class InputUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        while (!scanner.hasNextInt()) {
            new View().printMessage(OutputMessages.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static int getLength(){
        while (!scanner.hasNextInt()) {
            new View().printMessage(OutputMessages.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
