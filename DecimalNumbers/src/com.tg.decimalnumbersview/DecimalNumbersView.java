package com.tg.decimalnumbersview;
public class DecimalNumbersView {
    public static String SYSTEM = "Enter a system(2,8,16) = ";
    public static String INPUT_INT = "Enter a positive integer = ";
    public static String ERROR = "Error!You have to enter only positive numbers!";
    public static String RESULT = "Result = ";



    public void printMessage(String message){
        System.out.print(message);
    }

    public void printResult(String message,String result){
        System.out.print(message+result);

    }
}
