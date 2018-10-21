package model.entity;

public class Meat extends Goods{
    private String typeOfMeat;

    public Meat(String name, int amount, String typeOfMeat){
        super(name, amount);
        this.typeOfMeat = typeOfMeat;
    }

    @Override
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append(super.toString() + ", type of meat - " + typeOfMeat);
        return string.toString();
    }
}
