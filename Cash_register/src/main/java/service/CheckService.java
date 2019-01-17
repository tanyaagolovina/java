package service;

import model.Check;
import model.dao.entities.CheckDAO;

public class CheckService extends Service{
    private CheckDAO checkDAO;

    public CheckService(){
        checkDAO = daoFactory.getCheckDao();
    }

    public int openCheck(){
        return checkDAO.openCheck();
    }

    public boolean addProductToCheck(int checkID, int productID, int amount){
        return checkDAO.addProductToCheck(checkID, productID, amount);
    }

    public Check getByID(int ID){
        return (Check)checkDAO.getByID(ID);
    }

    public boolean cancelCheck(int ID){
        return checkDAO.cancel(ID);
    }

    public Check cancelProduct(int checkID,int productID){
        return checkDAO.cancelProductInCheck(checkID, productID);
    }
}
