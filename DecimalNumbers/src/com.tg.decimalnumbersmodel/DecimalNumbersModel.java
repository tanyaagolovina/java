package com.tg.decimalnumbersmodel;

import java.util.Scanner;
import com.tg.decimalnumbersview.DecimalNumbersView;


public class DecimalNumbersModel {
    private int number;
    private int system;
    private String newNumber;
    private String revertedNumber;
    public String hexadecimalNumb;

    public int setNumber(){
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        if (number<=0) {
            System.out.print(DecimalNumbersView.ERROR);
            return setNumber();
        } else {
            return number;
        }
    }
    public int setSystem(){
        Scanner in = new Scanner(System.in);
        system = in.nextInt();
        if(system==2 || system==8 || system==16){
            return system;
        } else {
            System.out.print(DecimalNumbersView.ERROR_SYSTEM);
            return setSystem();
        }
    }
    public void translateNumber(){
        newNumber = "";
        hexadecimalNumb = "0123456789ABCDEF";
        do{
            newNumber += hexadecimalNumb.charAt(number%system);
            number = number/system;
        }
        while(number>0);
    }
    public void revert(){
        revertedNumber = new StringBuffer(newNumber).reverse().toString();
    }
    public String getRevertedNumber(){
        return revertedNumber;
    }
}
