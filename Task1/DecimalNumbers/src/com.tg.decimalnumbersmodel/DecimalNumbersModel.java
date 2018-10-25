package com.tg.decimalnumbersmodel;



public class DecimalNumbersModel {
    private String newNumber;

    public void translateNumber(int number, int system){
        newNumber = "";
        String hexadecimalNumb = "0123456789ABCDEF";
        do{
            newNumber += hexadecimalNumb.charAt(number%system);
            number = number/system;
        }
        while(number>0);
    }
    private String revert(){
        return new StringBuffer(newNumber).reverse().toString();
    }
    public String getRevertedNumber(){
        return revert();
    }
}
