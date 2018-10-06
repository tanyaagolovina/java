package com.tg.PyramidView;

public class PyramidView {
    public static String INPUT_HEIGHT = "Enter a height of pyramid(positive integer): ";
    public static String ERROR = "Error! You have to enter a positive integer! Repeat: ";

    public void gapTyping(){
        System.out.print(" ");
    }
    public void printMessage(String message){
        System.out.print(message);
    }
    public void showPyramid(int height){
        for(int i=1;i<=height;i++){
            for(int j=1;j<=(height-i);j++){
                gapTyping();
            }
            for(int n=1;n<=i;n++) {
                System.out.print(n);
            }
            for(int m=1;m<=i;m++){
                if(m!=i) {
                    System.out.print(m);
                }
            }
            System.out.println();
        }
    }

}
