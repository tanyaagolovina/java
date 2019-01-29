package view;

import model.Salad;
import model.entity.Vegetable;
import java.util.ArrayList;
import java.util.Iterator;

public class CookView {

    public static void printMessage(String message) {
        if (message.length() == 0) {
            System.out.println(OutputMessages.NOTHING_TO_SHOW);
        } else {
            System.out.print(message);
        }
    }

    public void printIngredients(ArrayList<? extends Vegetable> vegetables){
        try {
            Iterator iterator = vegetables.iterator();
            while(iterator.hasNext())
                System.out.println(iterator.next());
            } catch (NullPointerException e) {
            System.out.println(OutputMessages.NOTHING_TO_SHOW);
            }
    }

    public void printSalads(ArrayList<Salad> salads) {
        if(salads.size()==0) {
            System.out.println(OutputMessages.NOTHING_TO_SHOW);
        } else {
            for(int salad = 0; salad < salads.size(); salad++){
                System.out.println(salads.get(salad));
            }
        }
    }

    public void printSortedSalads(Salad[] salads){
        try {
            for(Salad salad : salads){
                System.out.println(salad);
            }
        } catch (NullPointerException e) {
            System.out.println(OutputMessages.NOTHING_TO_SHOW);
        }
    }
}
