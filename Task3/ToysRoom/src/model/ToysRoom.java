package model;

import model.entity.Toy;

import java.util.Arrays;
import java.util.Comparator;

public class ToysRoom <T extends Toy> {
    private T[] toys;

    public void setToys(T[] toys){
        this.toys = toys;
    }

    public T[] getToys(){
        return toys;
    }

    public double sumPrice(){
        double sum = 0;
        for(T toy : toys) {
            sum += toy.getPrice();
        }
        return sum;
    }

    public T[] sortByName(){
        Arrays.sort(toys, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return toys;
    }

    public T[] sortByPrice(){
        Arrays.sort(toys, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        return toys;
    }

    public T[] findSpecificToy(String type, String name){
        T[] temp = selectToyOfType(type);
        int counter = 0;
        for(T toy : temp){
            if(toy.getName().equalsIgnoreCase(name)) {
                temp[counter] = toy;
                counter++;
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public T[] selectToyOfType(String type){
        T[] neededToys = Arrays.copyOf(toys, toys.length);
        int counter = 0 ;
        for(T toy : toys){
            if(toy.getClass().getSimpleName().equalsIgnoreCase(type)) {
                neededToys[counter] = toy;
                counter++;
            }
        }
        return Arrays.copyOf(neededToys, counter);
    }


}
