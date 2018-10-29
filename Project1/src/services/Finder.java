package services;

import model.Menu;
import model.Salad;
import model.entity.Vegetable;
import view.CookView;
import view.OutputMessages;

import java.util.ArrayList;

public class Finder {


    public ArrayList<Salad> findFromMenuByCalories(int min, int max, Menu menu){
        ArrayList<Salad> salads = new ArrayList<>();
        for(int salad = 0; salad < menu.getSalads().size(); salad++){
            if(menu.getSalads().get(salad).getCalories() >= min && menu.getSalads().get(salad).getCalories() <= max) {
                salads.add(menu.getSalads().get(salad));
            }
        }
        return salads;
    }

    public String findVegetables(Menu menu, String name){
        ArrayList<Salad> salads = menu.getSalads();
        StringBuffer result = new StringBuffer();
        for(int salad = 0; salad < salads.size(); salad++){
            if(salads.get(salad).getName().equalsIgnoreCase(name)) {
                salads.get(salad).getIngredients();
                result.append(salads.get(salad).getName() + ": " + salads.get(salad).getInfoAboutIngredients() + '\n');
            }
        }
        return result.toString();
    }
}
