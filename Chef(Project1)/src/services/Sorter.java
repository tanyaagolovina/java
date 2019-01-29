package services;

import model.Menu;
import model.Salad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sorter implements Comparator {

    public int compare(Object o1, Object o2){
        String name1 = ((Salad)o1).getName();
        String name2 = ((Salad)o2).getName();
        return name1.compareTo(name2);
    }

    public Salad[] sortByName( Menu menu){
        Salad[] salads = menu.getSaladsFromArray();
        Arrays.sort(salads, new Comparator<Salad>() {
            @Override
            public int compare(Salad o1, Salad o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return salads;
    }

}
