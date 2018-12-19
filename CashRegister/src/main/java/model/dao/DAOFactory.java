package model.dao;

import model.dao.entities.CheckDAO;
import model.dao.entities.ProductDAO;
import model.dao.entities.UserDAO;

public interface DAOFactory {
    int MYSQL = 1;

    UserDAO getUserDAO();
    ProductDAO getProductDAO();
    CheckDAO getCheckDao();

    static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL :
                return new MySQLDAOFactory();
            default : return null;
        }
    }
}
