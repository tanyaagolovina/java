package model.dao.mysql;

import model.Check;
import model.dao.AbstractDAO;
import model.dao.entities.CheckDAO;
import model.dao.entities.ProductDAO;
import model.entity.Product;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class MySQLCheckDAO extends CheckDAO {

    @Override
    public List getAll() {
        List<Check> checks = new ArrayList<>();
        try (Statement getAllStatement = connection.createStatement()) {
            ResultSet result = getAllStatement.executeQuery(queriesManager.getProperty("check.SELECT_ALL_CHECKS"));
            while (result.next()) {
                Check check = new Check();
                check.setCheckNumber(result.getInt(1));
                check.setDate(result.getTimestamp(2).toString());
                check.setStatus(result.getString(3));
                checks.add(check);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checks;
    }

    @Override
    public List<Check> getAllCanceledChecks() {
        List<Check> canceledChecks = new ArrayList<>();
        List<Check> allChecks = (ArrayList<Check>) getAll();
        for (int check = 0; check < getAll().size(); check++) {
            if (allChecks.get(check).getStatus().equalsIgnoreCase("canceled")) {
                canceledChecks.add(allChecks.get(check));
            }
        }
        return canceledChecks;
    }

    @Override
    public int openCheck() {
        Savepoint savepoint = null;
        int check_ID;
        try (PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("check.OPEN_CHECK"))) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Opening Check");
            check_ID = getLastInsertedCheck() + 1;
            ps.setInt(1, check_ID);
            ps.execute();
            connection.commit();
            connection.setAutoCommit(true);
            return getLastInsertedCheck();
        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            check_ID = 0;
            e.printStackTrace();
        }
        return check_ID;
    }

    @Override
    public boolean addProductToCheck(int checkID, int productID, int amount) {
        boolean flag = false;
        MySQLProductDAO productDAO = new MySQLProductDAO();
        if (productDAO.isInStock(productID, amount)) {
            try (PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("check.ADD_PRODUCT"))) {
                ps.setInt(1, checkID);
                ps.setInt(2, productID);
                ps.setInt(3, amount);
                flag = ps.executeUpdate() != 0;
                productDAO.subtractFromStock(productID, amount);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean cancel(int ID) {
        boolean flag = false;
        try (PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("check.UPDATE_STATUS"));
             PreparedStatement deleteAddedProducts = connection.prepareStatement(queriesManager.getProperty("check.DELETE_PRODUCTS"))) {
            ps.setInt(1, ID);
            deleteAddedProducts.setInt(1, ID);
            returnProductsToStock(ID);
            deleteAddedProducts.execute();
            flag = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Check cancelProductInCheck(int checkID, int productID) {
        Check check = null;
        MySQLProductDAO productDAO = new MySQLProductDAO();
        try (PreparedStatement cancelProduct = connection.prepareStatement(queriesManager.getProperty("check.DELETE_PRODUCT"))) {
            cancelProduct.setInt(1, checkID);
            cancelProduct.setInt(2, productID);
            productDAO.returnToStock(productID, getAmount(checkID, productID));
            cancelProduct.execute();
            check = getByID(checkID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    @Override
    public Check getByID(int checkID) {
        Check check = new Check();
        check.setCheckNumber(checkID);
        check.setProducts(getAllProductsFromCheck(checkID));
        check.setPrice(check.countTotalPrice());
        try (PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("check.GET_CHECK"))) {
            ps.setInt(1, checkID);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String date = result.getTimestamp(1).toString();
                check.setDate(date);
                check.setStatus(result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    private List<Product> getAllProductsFromCheck(int checkID) {
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("check.ALL_PRODUCTS_ID"))) {
            ps.setInt(1, checkID);
            ResultSet result = ps.executeQuery();
            productList = getAllProductsInRange(extractProductIdAndAmount(result));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    private List<Product> getAllProductsInRange(HashMap<Integer, Integer> productIdAndAmount) {
        List<Product> productList = new ArrayList<>();
        MySQLProductDAO productDAO = new MySQLProductDAO();
        List amount = productIdAndAmount.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        List keys = productIdAndAmount.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        for (int productID = 0; productID < productIdAndAmount.size(); productID++) {
            Product product = productDAO.getByID((int) keys.get(productID));
            product.setAmount((int) amount.get(productID));
            product.setPrice(product.getAmount() * product.getPrice());
            productList.add(product);
        }
        return productList;
    }

    private HashMap extractProductIdAndAmount(ResultSet result) throws SQLException {
        HashMap<Integer, Integer> idAndAmount = new HashMap<>();
        while (result.next()) {
            idAndAmount.put(result.getInt(1), result.getInt(2));
        }
        return idAndAmount;
    }

    private boolean returnProductsToStock(int checkID) throws SQLException {
        boolean flag = false;
        MySQLProductDAO productDAO = new MySQLProductDAO();
        List<Product> productList = getAllProductsFromCheck(checkID);
        for (int product = 0; product < productList.size(); product++) {
            flag = productDAO.returnToStock(productList.get(product).getId(), productList.get(product).getAmount());
        }
        return flag;
    }


    private int getLastInsertedCheck() {
        int lastID = 0;
        try (Statement st = connection.createStatement()) {
            ResultSet result = st.executeQuery(queriesManager.getProperty("check.SELECT_ALL_CHECKS"));
            lastID = result.last() ? result.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastID;
    }

    private int getAmount(int checkID, int productID) throws SQLException {
        int amount = 0;
        try (PreparedStatement getAmount = connection.prepareStatement(queriesManager.getProperty("check.GET_AMOUNT_OF_PRODUCT"))) {
            getAmount.setInt(1, checkID);
            getAmount.setInt(2, productID);
            ResultSet result = getAmount.executeQuery();
            while (result.next()) {
                amount = result.getInt(1);
            }
        }
        return amount;
    }

}
