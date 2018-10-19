package model.entity;

public abstract class Toy {
    private String name;
    private double price;

    public Toy(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }


    public double getPrice(){
        return price;
    }

    public abstract void play();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": name - " + name +
                ", price - " + price;
    }
}
