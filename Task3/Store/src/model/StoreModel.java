package model;

import model.entity.Goods;
import view.InputUtility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StoreModel {
    private ArrayList<Department> departments = new ArrayList<>();

    public ArrayList<Department> getDepartments(){
        return departments;
    }

    public void addDepartment(String nameOfDepartment, String location){
        departments.add(new Department(nameOfDepartment, location));
    }

    public void deleteDepartment(String nameOfDepartment) {
        for(int counter = 0; counter < departments.size(); counter++){
            if(departments.get(counter).getNameOfDepartment().equalsIgnoreCase(nameOfDepartment)) {
                departments.remove(departments.get(counter));
            }
        }
    }

    public void sortDepartments(){
        departments.sort(new Department());
    }

    public class Department implements Comparator {
        private String nameOfDepartment;
        private String location;
        private Goods[] goods;

        public Department(){

        }

        public Department(String nameOfDepartment, String location) {
            this.nameOfDepartment = nameOfDepartment;
            this.location = location;
            this.goods = new InputUtility().setGoods();

        }

        public String getNameOfDepartment() {
            return nameOfDepartment;
        }

        public void setNameOfDepartment(String nameOfDepartment) {
            this.nameOfDepartment = nameOfDepartment;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Goods[] getGoods() {
            return goods;
        }

        public void setGoods(Goods[] goods) {
            this.goods = goods;
        }

        @Override
        public int compare(Object o1, Object o2) {
            String name1 = ((Department)o1).getNameOfDepartment();
            String name2 = ((Department)o2).getNameOfDepartment();
            return name1.compareTo(name2);
        }

        @Override
        public String toString(){
            StringBuffer string = new StringBuffer();
            string.append("\n Department - " + nameOfDepartment + " is located in " + location + "\n"
            + "Goods: \n" + Arrays.toString(goods));
            return string.toString();
        }
    }
    @Override
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append("This is your store. \n Departments : " + departments);
        return string.toString();
    }
}
