package com.epam.task61.util;

import java.time.LocalDate;
import java.util.Locale;

public class Validator {
    private final static String TEXT
            = "^[A-Z][a-zA-Z,-:. ]*$";
    private final static String NUMBER_YEAR
            = "^(1\\d{3})|(20[10]\\d)$";
    private final static String NUMBER_PAGES
            = "^[1-9]\\d{0,3}$";

    public  static  boolean isCorrectString(String str) {
        return str.matches(TEXT);
    }

    public static boolean isCorrectYear(String year) {
        return year.matches(NUMBER_YEAR);
    }

    public static boolean isCorrectYear(int year) {
        return (year > 1580 &&
                year < LocalDate.now().getYear());
    }
}
