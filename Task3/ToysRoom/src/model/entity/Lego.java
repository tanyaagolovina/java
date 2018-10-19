package model.entity;

import view.ToysView;

public class Lego extends Toy{
    private String typeOfConstruction;
    private int amountOfBlocks;

    public Lego(String name, double price, String typeOfConstruction, int amountOfBlocks){
        super(name, price);
        this.typeOfConstruction = typeOfConstruction;
        this.amountOfBlocks = amountOfBlocks;
    }
    @Override
    public void play(){
        ToysView.printMessage("The " + typeOfConstruction + " is built");
    }

    @Override
    public String toString(){
        return super.toString() +
                ", " + typeOfConstruction +
                " consist of " + amountOfBlocks + "blocks";
    }
}
