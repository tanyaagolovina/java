package model.entity;

public abstract class Vegetable {
    protected String name;
    protected int calories;
    protected double price;

    public Vegetable(){

    }

    public Vegetable(String name, int calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return name + ": calories - " + calories + ", price - " + price;
    }
}
