package model.entity;

public class Bread extends Goods{
    private String color;

    public Bread(String name, int amount, String color){
        super(name, amount);
        this.color = color;
    }

    @Override
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append(super.toString() + ", type of bread - " + color);
        return string.toString();
    }
}
