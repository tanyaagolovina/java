package model.dao.entities;

import model.Check;
import model.dao.AbstractDAO;


public abstract class CheckDAO extends AbstractDAO {
    public abstract int openCheck();
    public abstract boolean addProductToCheck(int checkID, int productID, int amount);
    public abstract boolean cancel(int ID);
    public abstract Check cancelProductInCheck(int checkID, int productID);
}
