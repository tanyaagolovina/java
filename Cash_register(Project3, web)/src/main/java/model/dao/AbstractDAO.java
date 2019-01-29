package model.dao;

import model.dao.connection.MySQLConnection;
import model.dao.entities.CheckDAO;
import model.dao.entities.UserDAO;
import utils.managers.QueriesManager;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO <T>{

    protected Connection connection;
    protected QueriesManager queriesManager;


    public AbstractDAO(){
        connection = new MySQLConnection().getConnection();
        queriesManager = QueriesManager.INSTANCE;
    }

    public abstract List<T> getAll();
    public abstract T getByID(int ID);

}
