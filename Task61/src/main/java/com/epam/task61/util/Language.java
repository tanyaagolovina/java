package com.epam.task61.util;

import java.util.Locale;

public enum Language {
    ENG(new Locale("en","UK")),
    RU(new Locale("ru", "RU")),
    UA(new Locale("uk", "UA"));
    private Locale locale;

    private Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
