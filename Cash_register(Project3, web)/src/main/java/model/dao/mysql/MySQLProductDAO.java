package model.dao.mysql;

import model.dao.entities.ProductDAO;
import model.entity.Product;

import java.sql.*;
import java.util.*;

public class MySQLProductDAO extends ProductDAO {


    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(queriesManager.getProperty("product.GET_ALL"));
            return parseResultSet(result);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public Product getByID(int ID){
        Product product = null;
        try(PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("product.GET_BY_ID"))){
            ps.setInt(1, ID);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                product = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4));
            }
        } catch(SQLException e){
            product = null;
        }
        return product;
    }

    public boolean ifProductExist(int ID){
        Product product = getByID(ID);
        return product != null;
    }

    public Product addProduct(int id, String name, double price, int amount) {
        Product product = null;
        Savepoint savepoint = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(queriesManager.getProperty("product.INSERT_PRODUCT"))){
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Adding Product");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(3, price);
            preparedStatement.setInt(4, amount);
            preparedStatement.execute();
            product = new Product(id, name, price, amount);
            connection.commit();
            connection.setAutoCommit(true);
        } catch(SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return product;
    }

    public boolean deleteProduct(int productID) {
        boolean flag = false;
        Savepoint savepoint = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(queriesManager.getProperty("product.DELETE_PRODUCT"))) {
            savepoint = connection.setSavepoint("DeleteProduct");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, productID);
            flag = preparedStatement.executeUpdate() != 0;
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateProduct(double price, int productID) {
        boolean flag = false;
        Savepoint savepoint = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(queriesManager.getProperty("product.UPDATE_PRODUCT"))){
            savepoint = connection.setSavepoint("UpdateProduct");
            connection.setAutoCommit(false);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, productID);
            flag = preparedStatement.executeUpdate() != 0;
            connection.commit();
            connection.setAutoCommit(true);
        } catch(SQLException e){
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isInStock(int productID, int amount){
        int amountInStock = 0;
        try(PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("product.GET_AMOUNT_OF_PRODUCT"))) {
            ps.setInt(1, productID);
            ResultSet result = ps.executeQuery();
            while(result.next()) amountInStock = result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (amountInStock - amount) >= 0;

    }

    public boolean subtractFromStock(int productID, int amount) throws SQLException{
        boolean flag;
        try(PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("product.UPDATE_AMOUNT"))){
            int amountInStock = getByID(productID).getAmount();
            ps.setInt(1, (amountInStock - amount));
            ps.setInt(2, productID);
            flag = ps.executeUpdate() != 0;
        }
        return flag;
    }

    public boolean returnToStock(int productID, int amount) throws SQLException{
        boolean flag;
        try(PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("product.UPDATE_AMOUNT"))){
            int amountInStock = getByID(productID).getAmount();
            ps.setInt(1, (amountInStock + amount));
            ps.setInt(2, productID);
            flag = ps.executeUpdate() != 0;
        }
        return flag;
    }

    private List<Product> parseResultSet(ResultSet result) throws SQLException{
        List<Product> productList = new ArrayList<>();
        while (result.next()) {
            Product product = new Product();
            product.setId(result.getInt(1));
            product.setName(result.getString(2));
            product.setPrice(result.getDouble(3));
            product.setAmount(result.getInt(4));
            productList.add(product);
        }
        return productList;
    }
}
