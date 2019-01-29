package model.entity;

public abstract class Vegetable {
    private String name;
    private int calories;
    private double price;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return name + ": calories - " + calories + ", price - " + price;
    }
}
