package model.entity;


public abstract class Symbol {
    protected char symbol;
    protected static String regex;

    public abstract void defineRegex();

    public Symbol(){}

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }

    /*public static Symbol[] fillSymbols(char[] charArray){
        //System.out.println("Symbols:"+charArray.toString());
        Symbol[] temp = new Symbol[50];
        int counter = 0;
        Symbol symbTemp = null;
        for (char ch:charArray) {
            symbTemp.setSymbol(ch);
            temp[counter++] = symbTemp;
        }
        System.out.println(temp);
        return temp;
    }*/


}
