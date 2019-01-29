package model.entity;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends Symbol {

    private String word;


    public Word(){
    }

    public Word(String ww){
        this.word = ww;
    }



    @Override
    public void defineRegex() {
       regex = "([^A-ZА-Я][a-zа-я])+";
    }

    public String getRegex(){
        return regex;
    }

    public int length(){
        return word.length();
    }

    @Override
    public String toString() {
        return word;
    }

    public boolean containsSign(){
        Sign sign = new Sign();
        sign.defineRegex();
        Matcher matcher = Pattern.compile(word+sign.getRegex()).matcher(word);
        return matcher.matches();
    }

    @Override
    public boolean equals(Object obj) {
        Word word = (Word) obj;
        return this.word.matches(word.word);
    }
}
