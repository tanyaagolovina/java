package service;

import model.Check;
import model.User;

public class AdminService extends Service{

    public boolean cancelCheck(int checkID){
        return checkDAO.cancel(checkID);
    }

    public Check cancelProductInCheck(int checkID, int productID){
        return checkDAO.cancelProductInCheck(checkID, productID);
    }
}
