package com.tg.PyramidModel;

import com.tg.PyramidView.PyramidView;

import java.util.Scanner;

public class PyramidModel {
    private int height;

    public int setHeight(){
        Scanner in = new Scanner(System.in);
        height = in.nextInt();
        if(height<=0) {
            System.out.print(PyramidView.ERROR);
            return setHeight();
        } else {
            return height;
        }
    }

}
