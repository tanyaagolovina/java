package com.tg.decimalnumbersmodel;

import java.util.Scanner;
import com.tg.decimalnumbersview.DecimalNumbersView;


public class DecimalNumbersModel {
    private String newNumber;
    private String revertedNumber;

    public void translateNumber(int number, int system){
        newNumber = "";
        String hexadecimalNumb = "0123456789ABCDEF";
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
