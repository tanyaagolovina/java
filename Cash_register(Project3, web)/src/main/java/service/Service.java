package service;
import model.dao.DAOFactory;


public class Service {
    protected DAOFactory daoFactory;

    public Service(){
        daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    }


}
