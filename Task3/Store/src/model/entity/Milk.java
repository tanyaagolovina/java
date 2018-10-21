package model.entity;

public class Milk extends Goods {
    private double fat;

    public Milk(String name, int amount, double fat){
        super(name, amount);
        this.fat = fat;
    }


    @Override
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append(super.toString() + ", fat - " + fat);
        return string.toString();
    }

}
