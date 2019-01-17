package model.dao.entities;

import model.dao.AbstractDAO;
import model.entity.Product;

public abstract class ProductDAO extends AbstractDAO {

    public abstract Product addProduct(int id, String name, double price, int amount);
    public abstract boolean deleteProduct();
    public abstract boolean updateProduct(double price, int productID);
    public abstract boolean ifProductExist(int ID);
}
