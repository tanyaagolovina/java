package com.epam.task61.model.dao;


import com.epam.task61.model.Books;
import com.epam.task61.model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractDAO {
    protected Connection connector;
    public abstract <T> T[] getAll();
    public abstract boolean delete(String parameter);
    public abstract boolean update(String parameter);
    public abstract <T> T[] findByParameter(String statement,String value);
    public abstract <T> boolean add(T ... values);
}
