package com.tg.AbsoluteNumbersModel;

public class AbsoluteNumbersModel {
    public String findNumbers(int range) {
        int generalDivisor;
        String result = "";
        for(int numberFromRange = range; numberFromRange >= 1; numberFromRange--) {
            generalDivisor = 0;
            for (int divisor = 1; divisor < numberFromRange ; divisor++) {
                if(divisor <= numberFromRange/2) {
                    if (numberFromRange % divisor == 0) {
                        generalDivisor += divisor;
                    }
                }
            }
            if (generalDivisor == numberFromRange){
                result += " " + numberFromRange;
            }
        }
        return result;
    }

}
