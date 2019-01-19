package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Validator {

    public static boolean isValidID(ResultSet resultSet, int id) throws SQLException {
        boolean flag = true;
        while (resultSet.next()) {
            if(resultSet.getInt(1) == id) flag = false;
        }
        return flag;
    }
}
