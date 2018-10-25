package com.tg.PyramidView;

import java.util.ArrayList;

public class PyramidView {
    public static String INPUT_HEIGHT = "Enter a height of pyramid(positive integer): ";
    public static String ERROR = "Error! You have to enter a positive integer! Repeat: ";
    public static String ERROR_NAN = "It's not a number! Repeat: ";

    public static String gapTyping(){
        return " ";
    }
    public void printMessage(String message){
        System.out.print(message);
    }

    public void printPyramid(int height, int[][] pyramid){
        for(int level = 1; level < height+1; level++){
            for(int oneLevel = 1; oneLevel < height+1; oneLevel++){
                if(pyramid[level][oneLevel] == 0) {
                    System.out.print(" ");

                } else System.out.print(pyramid[level][oneLevel]);
            }
            System.out.println();
        }
    }
    /*public void showPyramid(int height){
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= (height-i); j++){
                gapTyping();
            }
            for(int n = 1; n <= i; n++) {
                System.out.print(n);
            }
            for(int m = 1; m <= i; m++){
                if(m != i) {
                    System.out.print(m);
                }
            }
            System.out.println();
        }
    }*/

}
