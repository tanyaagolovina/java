package model.dao.entities;

import model.Check;
import model.dao.AbstractDAO;

import java.util.ArrayList;
import java.util.List;


public abstract class CheckDAO extends AbstractDAO {
    public abstract int openCheck();
    public abstract boolean addProductToCheck(int checkID, int productID, int amount);
    public abstract boolean cancel(int ID);
    public abstract Check cancelProductInCheck(int checkID, int productID);
    public abstract List<Check> getAllCanceledChecks();
}
