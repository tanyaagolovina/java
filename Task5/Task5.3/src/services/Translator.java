package services;

import model.Dictionary;

import java.util.Map;


public class Translator {

    public static String translate(String line, Dictionary dictionary){
        Map dict = dictionary.getDictionary();
        String[] words = split(line);
        StringBuilder translation = new StringBuilder();
        for (int word = 0; word < words.length; word++) {
            if(dict.containsKey(words[word].toLowerCase())) {
                translation.append(dict.get(words[word].toLowerCase()) + " ");
            } else translation.append(words[word] + " ");
        }
        translation.append('\n');
        return translation.toString();
    }

    private static String[] split(String line){
        String[] words = line.split("[\\s,.!:]");
        return words;
    }
}
