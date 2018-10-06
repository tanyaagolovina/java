package com.tg.AbsoluteNumbersModel;

import com.tg.AbsoluteNumbersView.AbsoluteNumbersView;
import java.util.Scanner;

public class AbsoluteNumbersModel {
    private int range;

    public int setRange(){
        Scanner scanner = new Scanner(System.in);
        range = scanner.nextInt();
        if(range<=0) {
            System.out.print(AbsoluteNumbersView.ERROR);
            return setRange();
        } else {
            return range;
        }
    }
    public String findNumbers() {
        int divisor;
        String result = "";
        for(int i=range;i>=1;i--) {
            divisor = 0;
            for (int j=0;j<i;j++) {
                if(j!=0) {
                    if(j<=i/2) {
                        if (i % j == 0) {
                            divisor += j;
                        }
                    }
                }
            }
            if (divisor==i){
                result+=" "+i;
            }
        }
        return result;
    }

}
