package model.entity;

import java.util.Comparator;

public class Enum <T> {
    private String name;
    private int ordinal;
    private T[] arguments;

    public Enum(){

    }

    public Enum(String name, T ... args){
        ordinal = 0;
        this.name = name;
        this.arguments = args;
        /*for(T arg : args) {
            arguments[ordinal++] = arg;
        }*/
    }
    public String name(){
        return name;
    }

    public int ordinal(){
        return ordinal++;
    }

    public String getArguments(){
        StringBuffer result = new StringBuffer();
        for(T arg : arguments){
            result.append(arg + ", ");
        }
        return result.toString();
    }

    @Override
    public String toString(){
        return "Enum - " + name +
                ": " + getArguments();
    }
     public String values(){
         StringBuffer result = new StringBuffer();
         for(T arg : arguments) {
             result.append("Name - " + arg + ", ordinal - " + ordinal() + '\n');
         }
         return result.toString();
     }

}
