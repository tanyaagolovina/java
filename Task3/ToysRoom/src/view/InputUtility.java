package view;

import java.util.Scanner;

public class InputUtility {
    public static Scanner in = new Scanner(System.in);

    public static String getString(String message){
        System.out.print(message);
        return in.next();
    }
    public static int getInt(String message){
        System.out.print(message);
        while (!in.hasNextInt()) {
            ToysView.printMessage(ToysView.ERROR);
            in.next();
        }
        return in.nextInt();
    }

}
