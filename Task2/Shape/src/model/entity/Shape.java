package model.entity;

import model.entity.Drawable;

public abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor){
       this.shapeColor = shapeColor;
    }
    public String getShapeColor(){
        return shapeColor;
    }

    public abstract double calcArea();

    public abstract void draw();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": ShapeColor is " + shapeColor;
    }
}
