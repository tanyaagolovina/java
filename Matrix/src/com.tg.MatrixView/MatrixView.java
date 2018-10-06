package com.tg.MatrixView;

public class MatrixView {
    public static String INPUT_SIZE = "Enter a positive integer(size of matrix): ";
    public static String ERROR = "Error!You have to enter a positive number! Repeat: ";
    public static String MATRIX = "Initial matrix";
    public static String REVERTED_MATRIX = "Reverted matrix";

    public void printMessage(String message){
        System.out.print(message);
    }
    public void showMatrix(String message, int [][] arrMatrix){
        System.out.println(message);
        for(int i=0;i<arrMatrix.length;i++){
            for(int j=0;j<arrMatrix.length;j++){
                System.out.print(arrMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
