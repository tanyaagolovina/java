package service;


import model.User;
import model.dao.entities.UserDAO;

public class UserService extends Service{
    private UserDAO userDAO;

    public UserService(){
        userDAO = daoFactory.getUserDAO();
    }

    public User login(String username, String password, String role){
        userDAO = daoFactory.getUserDAO();
        return userDAO.getUser(username, password, role);
    }

}
