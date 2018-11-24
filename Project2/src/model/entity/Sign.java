package model.entity;

import java.util.regex.Pattern;

public class Sign extends Symbol {

    private Symbol sign;


    @Override
    public void defineRegex() {
        regex = "[?!,.]";
    }

    public static String getRegex(){
        return regex;
    }
}
