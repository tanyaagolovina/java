package service;

import model.ToysRoom;
import model.entity.Toy;

import java.util.Arrays;
import java.util.Comparator;

public class SearchUtility<T extends Toy> {
    private ToysRoom <T> model;


    public SearchUtility(ToysRoom<T> model){
        this.model = model;
    }

    public T[] sortByName(){
        T[] result =   model.getToys();
        Arrays.sort(result, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return result;
    }

    public T[] sortByPrice(){
        T[] result = model.getToys();
        Arrays.sort( result, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        return result;
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
        T[] neededToys = Arrays.copyOf(model.getToys(), model.getToys().length);
        int counter = 0 ;
        for(T toy : model.getToys()){
            if(toy.getClass().getSimpleName().equalsIgnoreCase(type)) {
                neededToys[counter] = toy;
                counter++;
            }
        }
        return Arrays.copyOf(neededToys, counter);
    }
    public double sumPrice(){
        double sum = 0;
        for(T toy : model.getToys()) {
            sum += toy.getPrice();
        }
        return sum;
    }
}
