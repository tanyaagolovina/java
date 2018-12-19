package model.dao;

import model.dao.connection.MySQLConnection;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO <T>{
    protected Connection connection;

    public AbstractDAO(){
        connection = new MySQLConnection().getConnection();
    }

    public abstract List<T> getAll();
    public abstract T getByID(int ID);
    /*public abstract boolean cancel(int ID);
    public abstract boolean delete();
    public abstract boolean update(T ... parameters);
    public abstract T add(T ... parameters);
    public abstract T create(T ... parameters);*/



}
