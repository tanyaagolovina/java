package com.tg.decimalnumbersmodel;

import java.util.Scanner;

public class DecimalNumbersModel {
    private int number;
    private int n;
    private String newNumber;
    private String revertedNumber;
    public String hexadecimalNumb;

    public void setNumber(){
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
    }
    public void setSystem(){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
    }
    public void translateNumber(){
        newNumber = "";
        hexadecimalNumb = "0123456789ABCDEF";
        do{
            newNumber += number%n;
            number = number/n;
        }
        while(n<=number);
        if(number>9){
            newNumber += hexadecimalNumb.charAt(number%n);
        } else {
            newNumber += number%n;
        }
    }
    public void revert(){
        revertedNumber = new StringBuffer(newNumber).reverse().toString();
    }
    public String getRevertedNumber(){
        return revertedNumber;
    }
    public boolean isPositiveNumber(){
        if(number<0) {
            return false;
        } else {
            return true;
        }
    }
}
