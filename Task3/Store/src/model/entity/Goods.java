package model.entity;

public abstract class Goods {
    private String name;
    private int amount;

    public Goods(String name, int amount){
        this.name = name;
        this.amount = amount;
    }


    @Override
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append('\n' + this.getClass().getSimpleName() + ": name - " + name + ", amount - " + amount);
        return string.toString();
    }
}
