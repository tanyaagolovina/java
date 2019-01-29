package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidID(ResultSet resultSet, int id) throws SQLException {
        boolean flag = true;
        while (resultSet.next()) {
            if(resultSet.getInt(1) == id) flag = false;
        }
        return flag;
    }

    public static boolean isValidInput(String input){
        return !input.isEmpty();
    }

    public static boolean isValidRole(String input){
        Pattern pattern = Pattern.compile("(admin)|(teller)|(specialist)");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
