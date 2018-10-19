package model.entity;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height){
       super(shapeColor);
       this.width = width;
       this.height = height;
    }
    @Override
    public double calcArea() {
        return (width*height)/2.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", width = " + width +
                ", height = " + height;
    }

    @Override
    public void draw() {
        toString();
    }
}
