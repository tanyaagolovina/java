package model;

import com.tg.PyramidView.PyramidView;

import java.util.ArrayList;

public class PyramidModel {
    private int height;

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight(){
        return height;
    }
    public int [][] buildPyramid(){
       int [][] pyramid = new int[height][height];
        for(int level = 1; level <= height; level++){
            for(int gapsInLevel = 1; gapsInLevel <= (height-level); gapsInLevel++){
                pyramid[level][gapsInLevel] = 0;
            }
            for(int middleOfLevel = 1; middleOfLevel <= level; middleOfLevel++) {
                pyramid[level][middleOfLevel] = middleOfLevel;
            }
            for(int secondPartOfLevel = 1; secondPartOfLevel <= level; secondPartOfLevel++){
                if(secondPartOfLevel != level) {
                    pyramid[level][secondPartOfLevel] = secondPartOfLevel;
                }
            }
            //System.out.println();
        }
        return pyramid;
    }
}
