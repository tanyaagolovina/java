package view;

import model.StoreModel;
import model.entity.Goods;

import java.util.ArrayList;

public class StoreView {

    public static void printMessage(String message){
        System.out.print(message);
    }

    public void printDepartemtsFromArray(StoreModel.Department[] departments){
        for(StoreModel.Department dep : departments){
            System.out.println(dep);
        }
    }

    public void printDepartments(ArrayList<StoreModel.Department> departments){
        if(departments.size() != 0) {
            for (StoreModel.Department department : departments) {
                System.out.println(department);
            }
        } else printMessage("You do not have any departments in your shop");
    }
}
