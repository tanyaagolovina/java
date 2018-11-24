package view;

import java.util.ArrayList;

public class View {

    public void printMessage(String message){
        System.out.println(message);
    }


    public <T> void printArrayList(ArrayList<T> lines){
        if(lines.size() == 0)  System.out.println(OutputMessages.NO_RESULT);
        else {
            for (int i = 0; i < lines.size() ; i++) {
                System.out.println(lines.get(i));
            }
        }
    }


}
