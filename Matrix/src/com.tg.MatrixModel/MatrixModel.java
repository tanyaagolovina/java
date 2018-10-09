package com.tg.MatrixModel;


public class MatrixModel {
    private int [][] arr;

    public int random(){
        double randomNumber = Math.random();
        randomNumber = randomNumber*100;
        int randomInt = (int)randomNumber - 50;
        return randomInt;
    }
    public int[][] createMatrix(int size){
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
