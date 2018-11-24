package model.entity;

public class Space extends Symbol {

    private Symbol[] space;

    @Override
    public void defineRegex() {
        regex = "[\\s\\n]+";
    }

    public String getRegex(){
        return regex;
    }
}
