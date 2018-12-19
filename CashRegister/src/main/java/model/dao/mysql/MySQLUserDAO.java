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

    private final String GET_ALL = "SELECT * FROM users";
    private final String GET_USER = "SELECT * FROM users WHERE username = ? AND password = ?";

    @Override
    public List getAll() {
        List<User> users = new ArrayList<>();
        try(Statement st = connection.createStatement()){
            ResultSet result = st.executeQuery(GET_ALL);
            users = parseResultSet(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Object getByID(int ID) {
        return null;
    }

    @Override
    public boolean getUser(String username, String password, String role) {
        User user = null;
        try(PreparedStatement ps = connection.prepareStatement(GET_USER)){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if(result.getString(3).matches(role)){
                user = parseResultSet(result).get(0);
            }
        } catch (SQLException e) {
            System.out.println("Incorrect entered data");
            //e.printStackTrace();
        }
        return user.isNotNull();
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

}
