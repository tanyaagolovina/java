package model;

import model.entity.Enum;

public class MyEnum <T extends Enum> {

    private T[] enums;

    public void setEnums(T[] enums){
        this.enums = enums;
    }

    public T[] getEnums(){
        return enums;
    }

    public T valueOf(String nameOfEnum){
        for(T item : enums) {
            if(item.name().equalsIgnoreCase(nameOfEnum)) return item;
        }
        return null;
    }

    public String getNamesOfEnums(){
        StringBuffer result = new StringBuffer();
        for(T item : enums) {
            result.append(item.name() + '\n');
        }
        return result.toString();
    }

    public String valuesOfEnums(){
        StringBuffer result = new StringBuffer();
        for(T item : enums) {
            result.append(item.values() + '\n');
        }
        return result.toString();
    }


}
