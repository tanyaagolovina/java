package utils;

import java.util.Locale;

public enum Language {
    EN(new Locale("en","UK")),
    RU(new Locale("ru", "RU"));

    private Locale locale;

    Language(Locale locale){
        this.locale = locale;
    }

    public Locale getLocale(){
        return locale;
    }
}
