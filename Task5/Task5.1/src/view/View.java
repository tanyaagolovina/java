package view;

import model.entity.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class View {

    public static void printMessage(String message){
        System.out.print(message);
    }

    public static void printNotes(ArrayList<Student> students){
        if(students.isEmpty()) {
            System.out.println("Nothing to show");
        } else {
            Iterator<Student> iterator = students.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
