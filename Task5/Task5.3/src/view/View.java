package view;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class View {

    public static void printMessage(String message){
        System.out.print(message);
    }

    public void printDictionary(Map dictionary){
        Set<Map.Entry<String, String>> set = dictionary.entrySet();
        Iterator <Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry word = iterator.next();
            System.out.println(word.getKey() + " - " + word.getValue());
        }
    }
}
