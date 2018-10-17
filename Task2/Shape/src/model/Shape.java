package model;

public abstract class Shape implements Drawable{
    private String shapeColor;

    public Shape(String shapeColor){
       this.shapeColor = shapeColor;
    }
    public String getShapeColor(){
        return shapeColor;
    }
    public abstract int calcArea();

    @Override
    public String toString() {
        return super.toString();
    }
}
