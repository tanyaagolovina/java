package model;

import model.entity.Circle;
import model.entity.Rectangle;
import model.entity.Shape;
import model.entity.Triangle;

import java.util.Arrays;
import java.util.Comparator;

public class Shapes {

    private Shape[] shapes;

    public void setShapes(Shape[] shapes){
       this.shapes = shapes;
    }

    public Shape[] getShapes(){
        return shapes;
    }

    public double calcSumArea(){
        double sum = 0;
        for(Shape shape : shapes) {
            sum += shape.calcArea();
        }
        return sum;
    }

    public double sumAreasByShape(String findBy){
        double result = 0;
        for(Shape shape : shapes) {
            if((shape instanceof Triangle) && (findBy.equalsIgnoreCase("triangle"))) {
                result += shape.calcArea();
            } else if ((shape instanceof Rectangle) && (findBy.equalsIgnoreCase("rectangle"))){
                result += shape.calcArea();
            } else if((shape instanceof Circle) && (findBy.equalsIgnoreCase("circle"))) {
                result += shape.calcArea();
            }
        }
        return result;
    }

    public Shape[] sortByColor(){
        Arrays.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getShapeColor().compareTo(o2.getShapeColor());
            }
        });
        return shapes;
    }

    public Shape[] sortByArea(){
        Arrays.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int)(o1.calcArea() -  o2.calcArea());
            }
        });
        return shapes;
    }

}
