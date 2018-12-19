package model;

import model.entity.Product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Check {

    private List<Product> products = new ArrayList<>();
    private double totalPrice;
    private String date;
    private int checkNumber;


    public Check(){
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public double getPrice(){
        return totalPrice;
    }

    public void addProduct(Product product){
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void deleteProduct(Product product){
        products.remove(product);
        totalPrice -= product.getPrice();
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public double countTotalPrice(){
        double tempPrice = 0;
        for (int product = 0; product < products.size(); product++) {
            tempPrice += products.get(product).getPrice();
        }
        return tempPrice;
    }

    private String productsToString(){
        StringBuilder productsList = new StringBuilder();
        for (Product product:products) {
            productsList.append(product+"\n");
        }
        return productsList.toString();
    }

    @Override
    public String toString() {
        return "Check number " + checkNumber + '\n' +
                productsToString() + '\n' +
                "Total price = " + totalPrice + '\n' +
                "Date: " + date + '\n';
    }
}
