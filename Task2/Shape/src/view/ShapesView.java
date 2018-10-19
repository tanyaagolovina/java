package view;

import model.entity.Shape;

public class ShapesView {
    public static String MENU = "1. To sum areas of all shapes enter - sum. \n" +
            "2. To sum all areas of specific shapes enter - specific shape(e.g. triangle) \n"+
            "3. To order shapes by area enter - area \n"+
            "4. To order shapes by color enter - color \n"+
            "5. To exit enter - exit \n";

    public static String SUM = "Sum of areas = ";
    public static String WHAT_TO_DO = "What do you want to do? ";
    public static String ERROR = "Error! Please verify that all data that you entered is correct. Repeat : ";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printShapes(Shape[] shapes){
        for(Shape shape : shapes){
           System.out.println(shape);
        }
    }

    public void printSum(String message, double result){
        System.out.print(message);
        System.out.printf("%.2f", result);
        System.out.println();
    }
}
