package service;

import model.User;
import model.dao.DAOFactory;
import model.dao.entities.CheckDAO;
import model.dao.entities.ProductDAO;
import model.dao.entities.UserDAO;

public class Service {
    private DAOFactory daoFactory;
    protected UserDAO userDAO;
    protected ProductDAO productDAO;
    protected CheckDAO checkDAO;

    public Service(){
        daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        userDAO = daoFactory.getUserDAO();
        productDAO = daoFactory.getProductDAO();
        checkDAO = daoFactory.getCheckDao();
    }

    public boolean login(String username, String password, String role){
        return userDAO.getUser(username, password, role);
    }
}
