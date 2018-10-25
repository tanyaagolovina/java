package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidPhoneNumber(String phone){
        String regular = "\\+[1-9]\\d{0,2}\\(\\d{2}\\)(\\d{2}-){2}\\d{3}";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidName(String name){
        String regular = "[A-Z][a-z]+";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidAddress(String address){
        String regular = "([A-Z][a-z]+)( [a-zA-Z][a-z]+)*( )*(,( )*\\d+){2}";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    public static boolean isValidDateOfBirth(String date){
        String regular = "((([0][1-9])||([1-2]\\d)||([3][0-1])).)((([1][0-2])||([0][1-9])).)(([1][9][2-9]\\d)||([2][0][0-1][0-8]))";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static boolean isValidInput(String input){
        String regular = "[1-3]";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
