package com.tg.AbsoluteNumbersView;

import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int getInt(){
        while(!sc.hasNextInt()) {
            new AbsoluteNumbersView().printMessage(OutputMessages.ERROR);
            sc.next();
        }
        return sc.nextInt();
    }
}
