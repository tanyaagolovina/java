package model.dao.entities;

import model.User;
import model.dao.AbstractDAO;

import java.util.List;

public abstract class UserDAO extends AbstractDAO {

    public UserDAO(){super();}
    public abstract User getUser(String username, String password, String role);
}
