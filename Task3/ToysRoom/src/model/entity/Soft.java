package model.entity;

import view.ToysView;

public class Soft extends Toy{
    private String typeOfToy;
    private String color;

    public Soft(String name, double price, String typeOfToy, String color){
        super(name, price);
        this.typeOfToy = typeOfToy;
        this.color = color;
    }

    @Override
    public void play(){
        ToysView.printMessage("The " + typeOfToy + " has " + color + "color");
    }

    @Override
    public String toString(){
        return super.toString() +
                ", type of toy - " + typeOfToy +
                ", color - " + color;
    }
}
