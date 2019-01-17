package service;

import model.Check;
import model.User;

public class UserService extends Service{

    public boolean cancelCheck(int checkID){
        //return checkDAO.cancel(checkID);
        return false;
    }

    public Check cancelProductInCheck(int checkID, int productID){
        //return checkDAO.cancelProductInCheck(checkID, productID);
        return null;
    }
}
