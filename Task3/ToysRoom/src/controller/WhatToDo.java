package controller;

import model.ToysRoom;
import model.entity.Toy;
import view.InputUtility;
import view.ToysView;

public class WhatToDo {
    enum Input {
        ALL_TOYS{
            public String toString(){
                return "All toys: ";
            }
        },
        SPECIFIC_TYPE{
            public String toString(){
                return "Search by specific type of toy";
            }
        },
        SPECIFIC_NAME{
            public String toString(){
                return "Search by specific name";
            }
        },
        PRICE{
            public String toString(){
                return "Price of all toys : ";
            }
        }, NAME{
            public String toString(){
                return "Sorting all toys by name";
            }
        },
        EXIT{
            public String toString(){
                return "Bye!)";
            }
        }
    }

    public static void executeBy(int term, ToysRoom toy){
        if(term == 1){
            new ToysView().printResult(ToysView.PRICE, toy.sumPrice());
        } else if(term == 2){
            String type = InputUtility.getString(ToysView.TYPE);
            new ToysView().printToys(toy.selectToyOfType(type));
        } else if (term == 3){
            String type = InputUtility.getString(ToysView.TYPE);
            String name = InputUtility.getString(ToysView.NAME);
            new ToysView().printToys(toy.findSpecificToy(type, name));
        } else if (term == 4){
            new ToysView().printToys(toy.sortByPrice());
        } else if (term == 5){
            new ToysView().printToys(toy.sortByName());
        } else if(term != 6){
            ToysView.printMessage(ToysView.ERROR);
            return;
        }
    }

}
