package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator{
    public static boolean isValidWord(String word){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    public static boolean isValidLine(String line){
        Pattern pattern = Pattern.compile("(\\w+||\\p{Print}?||\\p{Blank}?)+");
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public static boolean isValidInput(String input){
        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
