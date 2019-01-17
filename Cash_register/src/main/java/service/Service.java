package service;

import model.User;
import model.dao.DAOFactory;
import model.dao.entities.ProductDAO;
import model.dao.entities.UserDAO;
import utils.managers.MessageManager;


public class Service {
    protected DAOFactory daoFactory;
    private UserDAO userDAO;
    private ProductDAO productDAO;
    //protected CheckDAO checkDAO;
    private MessageManager manager;

    public Service(){
        daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        userDAO = daoFactory.getUserDAO();
        productDAO = daoFactory.getProductDAO();
        //checkDAO = daoFactory.getCheckDao();
        manager = new MessageManager();
    }

    public User login(String username, String password, String role){
        return userDAO.getUser(username, password, role);
    }

    /*public void changeLanguage(String str){
        //Language [] languages = Language.values();
        Locale locale = Locale.getDefault();
        for (Language lang:Language.values()) {
            if(lang.toString().equalsIgnoreCase(str)) {
                locale = lang.getLocale();
            }
        }
        manager.changeLocale(locale);
    }*/
}
