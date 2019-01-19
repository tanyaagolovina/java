package service;

import model.Check;
import model.dao.entities.CheckDAO;

import java.util.ArrayList;
import java.util.List;

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

    public List<Check> getAll(int currentPage, int recordsPerPage){
        int start = currentPage * recordsPerPage - recordsPerPage;
        List<Check> checksPerPage = checkDAO.getAll().subList(start, currentPage*recordsPerPage);
        return checksPerPage;
    }

    public int getAllRows(){
        return checkDAO.getAll().size();
    }

    public List<Check> getCanceledChecks(){
        return checkDAO.getAllCanceledChecks();
    }

}
