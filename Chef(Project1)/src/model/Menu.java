package model;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Salad> salads = new ArrayList<>();

    public Salad[] getSaladsFromArray(){
        Salad[] temp = new Salad[salads.size()];
        for(int salad = 0; salad < salads.size(); salad++){
            temp[salad] = salads.get(salad);
        }
        return temp;
    }

    public ArrayList<Salad> getSalads(){
        return salads;
    }

    public void addSalad(Salad salad){
        salads.add(salad);
    }

    public void deleteSalad(String name){
        for(int salad = 0; salad < salads.size(); salad++) {
            if(salads.get(salad).getName().equalsIgnoreCase(name)) {
                salads.remove(salad);
            }
        }
    }
    public String toString(){
        return salads.toString();
    }

}
