package com.tg.decimalnumbersview;

import java.util.Scanner;

public class InputUtility {
    private static Scanner in = new Scanner(System.in);

    public static int getInt(){
        //DecimalNumbersView.printMessage(OutputMessages.INPUT_INT);
        while(!in.hasNextInt()){
            DecimalNumbersView.printMessage(OutputMessages.ERROR_NAN);
            in.next();
        }
        return in.nextInt();
    }
}
