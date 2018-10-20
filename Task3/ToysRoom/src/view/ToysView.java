package view;

import model.entity.Toy;

public class ToysView {
    public static  String MENU = "This is toy room. \n" +
            "1. To calculate price of all toys enter - 1 \n" +
            "2. To look through all toys of specific type enter - 2 \n" +
            "3. To find toys of specific type with specific name enter - 3 \n" +
            "4. To sort toys by price enter - 4 \n" +
            "5. To sort toys by name enter - 5 \n" +
            "6. To exit enter - 6";

    public static String TYPE = "Enter a type(soft or lego) : ";
    public static String NAME = "Enter a name: ";
    public static String ERROR = "Error! Please verify entered data! Repeat : ";
    public static String PRICE = "Sum  = ";
    public static String WHAT_TO_DO = "\n What do you want to do? ";



    public static void printMessage(String message){
        System.out.print(message);
    }

    public void printToys(Toy[] toys){
        if (toys.length != 0) {
            for (Toy toy : toys) {
                System.out.println(toy);
            }
        } else System.out.println("Nothing had been found");
    }

    public void printResult(String message, double result){
        System.out.print(message);
        System.out.printf("%.2f", result);
    }
}
