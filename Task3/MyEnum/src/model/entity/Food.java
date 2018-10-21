package model.entity;

import model.MyEnum;

public class Food extends Enum {
     public static Enum<String> MEAT = new Enum<>("MEAT", "MUTTON", "RABBIT","PORK");
     public static Enum<String> BREAD = new Enum<>("BREAD", "WHITE", "BLACK");
     public static Enum<String> MILK = new Enum<>("MILK", "KEFIR", "CHEESE", "AIRAN","BUTTER");

     public static Enum[] getEnums(){
         Enum[] food = {MILK, BREAD, MEAT};
         return food;
     }
}
