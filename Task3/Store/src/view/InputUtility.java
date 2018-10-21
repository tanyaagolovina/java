package view;

import model.entity.Bread;
import model.entity.Goods;
import model.entity.Meat;
import model.entity.Milk;

import java.util.Scanner;

public class InputUtility {
    private Scanner in = new Scanner(System.in);

    public int getInt(){
        while(!(in.hasNextInt())){
            StoreView.printMessage(OutputMessages.ERROR);
            in.next();
        }
        return in.nextInt();
    }

    public double getDouble(){
        while(!(in.hasNextDouble())){
            StoreView.printMessage(OutputMessages.ERROR);
            in.next();
        }
        return in.nextDouble();
    }

    public String getString(){
        return in.next();
    }

    public Goods[] setGoods(){
        StoreView.printMessage(OutputMessages.ADD_AMOUNT);
        int amount = getInt();
        Goods[] goods = new Goods[amount];
        for(int i = 0; i < amount; i++){
            StoreView.printMessage( (i+1) + " product: \n");
            StoreView.printMessage(OutputMessages.TYPE_OF_PRODUCT);
            goods[i] = setGood(getString());
        }
        return goods;
    }

    public Goods setGood(String input){
        if (input.equalsIgnoreCase("milk")) {
            StoreView.printMessage(OutputMessages.NAME_OF_PRODUCT);
            String name = in.next();
            StoreView.printMessage(OutputMessages.ADD_AMOUNT);
            int amount = getInt();
            StoreView.printMessage(OutputMessages.FAT);
            double fat = getDouble();
            Goods good = new Milk(name, amount, fat);
            return good;
        } else if (input.equalsIgnoreCase("meat")){
            StoreView.printMessage(OutputMessages.NAME_OF_PRODUCT);
            String name = in.next();
            StoreView.printMessage(OutputMessages.ADD_AMOUNT);
            int amount = getInt();
            StoreView.printMessage(OutputMessages.TYPE_OF_MEAT);
            String type = getString();
            Goods good = new Meat(name, amount, type);
            return good;
        } else if(input.equalsIgnoreCase("bread")){
            StoreView.printMessage(OutputMessages.NAME);
            String name = in.next();
            StoreView.printMessage(OutputMessages.ADD_AMOUNT);
            int amount = getInt();
            StoreView.printMessage(OutputMessages.TYPE_OF_BREAD);
            String type = getString();
            Goods good = new Bread(name, amount, type);
            return good;
        } else {
            StoreView.printMessage(OutputMessages.DOES_NOT_EXIST);
            return null;
        }
    }
}
