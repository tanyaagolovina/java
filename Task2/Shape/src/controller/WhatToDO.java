package controller;

import model.Shapes;
import view.ShapesView;

public class WhatToDO {
    public static void executeBy(String term, Shapes shape){
        if(term.trim().equalsIgnoreCase("sum")) {
            new ShapesView().printSum(ShapesView.SUM, shape.calcSumArea());
        } else if(term.trim().equalsIgnoreCase("triangle") || term.equalsIgnoreCase("rectangle") ||
                term.equalsIgnoreCase("circle")){
            new ShapesView().printSum(ShapesView.SUM, shape.sumAreasByShape(term));
        } else if (term.trim().equalsIgnoreCase("color")){
            new ShapesView().printShapes(shape.sortByColor());
        } else if (term.trim().equalsIgnoreCase("area")){
            new ShapesView().printShapes(shape.sortByArea());
        } else if (!(term.trim().equalsIgnoreCase("exit"))) {
            new ShapesView().printMessage(ShapesView.ERROR);
            return;
        }
    }
}
