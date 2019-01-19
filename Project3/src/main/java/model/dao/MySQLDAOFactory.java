package model.dao;

import model.dao.entities.CheckDAO;
import model.dao.entities.ProductDAO;
import model.dao.entities.UserDAO;
import model.dao.mysql.MySQLCheckDAO;
import model.dao.mysql.MySQLProductDAO;
import model.dao.mysql.MySQLUserDAO;


public class MySQLDAOFactory implements DAOFactory{

    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    public ProductDAO getProductDAO() {
        return new MySQLProductDAO();
    }

    public CheckDAO getCheckDao() {
        return new MySQLCheckDAO();
    }
}
