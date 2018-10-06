package com.tg.MatrixModel;

import com.tg.MatrixView.MatrixView;

import java.util.Scanner;

public class MatrixModel {
    private int [][] arr;
    private int size;

    public int setSize(){
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        if(size<=0) {
            System.out.print(MatrixView.ERROR);
            return setSize();
        } else {
            return size;
        }
    }
    public int random(){
        double randomNumber = Math.random();
        randomNumber = randomNumber*100;
        int randomInt = (int)randomNumber - 50;
        return randomInt;
    }
    public int[][] createMatrix(){
        arr = new int [size][size];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j] = random();
            }
        }
        return arr;
    }
    public int[][] revertMatrix(){
        int temp;
        for(int i=0;i<arr.length/2;i++){
            for(int j=i;j<arr.length-1-i;j++){
                temp = arr[i][j];
                arr[i][j] = arr[j][arr.length-1-i];
                arr[j][arr.length-1-i] = arr[arr.length-1-i][arr.length-1-j];
                arr[arr.length-1-i][arr.length-1-j] = arr[arr.length-1-j][i];
                arr[arr.length-1-j][i] = temp;
            }
        }
        return arr;
    }
}
