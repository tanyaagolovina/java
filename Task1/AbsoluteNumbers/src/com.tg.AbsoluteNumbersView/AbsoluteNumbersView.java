package com.tg.AbsoluteNumbersView;

public class AbsoluteNumbersView {
    public static String INPUT_VALUE = "Enter a positive integer: ";
    public static String ERROR = "Error! You have to enter a positive integer! Repeat : ";
    public static String RESULT = "Absolute numbers : ";

    public void printMessage(String message){
        System.out.print(message);
    }
    public void printResult(String message, String result) {
        System.out.print(message+result);
    }

}
