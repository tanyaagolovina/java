package service;

import model.dao.entities.ProductDAO;
import model.entity.Product;

public class ProductService extends Service {
    private ProductDAO productDAO;

    public ProductService(){
        productDAO = daoFactory.getProductDAO();
    }

    public Product createProduct(int productID, String name, double price, int amount){
        return productDAO.addProduct(productID, name, price, amount);
    }


    public boolean ifProductExist(int productID){
        return productDAO.ifProductExist(productID);
    }
}
