package model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map dictionary = new HashMap<String,String>();

    public Dictionary(){

    }

    public void setDictionary(Map dictionary){
        this.dictionary = dictionary;
    }

    public Map getDictionary(){
        return dictionary;
    }

    public void addWord(String englishWord, String russianWord){
        dictionary.put(englishWord, russianWord);
    }

}
