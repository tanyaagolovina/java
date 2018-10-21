package view;

public class View<T> {

    public void printEnums(T[] enums){
        for(T item : enums){
            System.out.println(item);
        }
    }

    public void printOneEnum(T item){
        System.out.println(item);
    }

    public void printMessage(String message){
       System.out.println(message);
    }
}
