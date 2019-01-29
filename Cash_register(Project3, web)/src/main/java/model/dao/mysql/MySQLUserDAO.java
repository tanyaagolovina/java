package model.dao.mysql;

import model.User;
import model.dao.entities.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO extends UserDAO {

    @Override
    public List getAll() {
        List<User> users = new ArrayList<>();
        try(Statement st = connection.createStatement()){
            ResultSet result = st.executeQuery(queriesManager.getProperty("user.GET_ALL"));
            users = parseResultSet(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(String username, String password, String role) {
        User user = null;
        try(PreparedStatement ps = connection.prepareStatement(queriesManager.getProperty("user.GET_USER"))){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                if(result.getString(3).matches(role)){
                    user = new User();
                    user.setUsername(result.getString(1));
                    user.setPassword(result.getString(2));
                    user.setRole(result.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private List<User> parseResultSet(ResultSet result) throws SQLException {
        List<User> users = new ArrayList<>();
        while(result.next()) {
            User user = new User();
            user.setUsername(result.getString(1));
            user.setPassword(result.getString(2));
            user.setRole(result.getString(3));
            users.add(user);
        }
        return users;
    }

    @Override
    public Object getByID(int ID) {
        return null;
    }

}
