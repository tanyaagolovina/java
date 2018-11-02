package model;

import model.entity.Vegetable;

import java.util.ArrayList;

public class Salad <T extends Vegetable> {
    private String name;
    private ArrayList<T> ingredients = new ArrayList<>();
    private Counter counter = new Counter();

    public Salad(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIngredients(ArrayList<T> vegetables){
        for(int ingredient = 0; ingredient < vegetables.size(); ingredient++){
           ingredients.add(vegetables.get(ingredient));
        }
    }

    public String getName(){
        return name;
    }

    public int getCalories(){
        return counter.countCalories();
    }


    public String getIngredients(){
        StringBuffer ingredientsString = new StringBuffer();
        for(int vegetable = 0; vegetable < ingredients.size(); vegetable++){
            ingredientsString.append(ingredients.get(vegetable).getName() + " ");
        }
        return ingredientsString.toString();
    }


    public String toString(){
        return name + ": " + getIngredients() + "\n" +
                "Calories - " + counter.countCalories() +"\n" +
                "Price - " + counter.countPrice();
    }

    public String getInfoAboutIngredients() {
        StringBuffer info = new StringBuffer();
        for (int vegetable = 0; vegetable < ingredients.size(); vegetable++) {
            info.append(ingredients.get(vegetable).getName() + ": calories - " + ingredients.get(vegetable).getCalories() +
                    ", price - " + ingredients.get(vegetable).getPrice());
        }
        return ingredients.toString();
    }

    public class Counter{


        public int countCalories(){
            int totalCalories = 0;
            for(int vegetable = 0; vegetable < ingredients.size(); vegetable++){
                totalCalories += ingredients.get(vegetable).getCalories();
            }
            return totalCalories;
        }
        public double countPrice(){
            double totalPrice = 0;
            for(int vegetable = 0; vegetable <  ingredients.size(); vegetable++){
                totalPrice += ingredients.get(vegetable).getPrice();
            }
            return totalPrice;
        }



        }

    }
