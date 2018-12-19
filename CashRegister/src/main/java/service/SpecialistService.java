package service;

import model.entity.Product;

public class SpecialistService extends Service {

    public Product createProduct(int productID, String name, double price, int amount){
        return productDAO.addProduct(productID, name, price, amount);
    }
}
