package com.epam.task61.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResorceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;


    ResorceManager() {
        resourceBundle = ResourceBundle.getBundle("proporties.message", Locale.getDefault());
    }

    public void changeLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle("proporties.message", locale);
    }

    public String getMessage(String key){
        return resourceBundle.getString(key);
    }
}
