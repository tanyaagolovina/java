package model;

import model.entity.Toy;



public class ToysRoom <T extends Toy> {
    private T[] toys;

    public void setToys(T[] toys){
        this.toys = toys;
    }

    public T[] getToys(){
        return toys;
    }
}
