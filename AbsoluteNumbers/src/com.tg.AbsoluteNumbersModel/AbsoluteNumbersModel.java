package com.tg.AbsoluteNumbersModel;

public class AbsoluteNumbersModel {
    public String findNumbers(int range) {
        int divisor;
        String result = "";
        for(int i = range; i >= 1; i--) {
            divisor = 0;
            for (int j = 0; j < i; j++) {
                if(j != 0) {
                    if(j <= i/2) {
                        if (i % j == 0) {
                            divisor += j;
                        }
                    }
                }
            }
            if (divisor == i){
                result += " " + i;
            }
        }
        return result;
    }

}
