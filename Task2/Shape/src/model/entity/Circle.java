package model.entity;

public class Circle extends Shape {
    private double radius;
    private final double PI = 3.14;

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    public double calcArea(){
        return PI*(radius*radius);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", radius = " + radius;
    }

    public void draw(){
        toString();
    }

}
