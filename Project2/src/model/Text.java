package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    private ArrayList<String> text = new ArrayList<>();
    private String textLine;

    public Text(){
    }

    public Text(String lines) {
        textLine = lines;
    }


    public ArrayList<String> textToArray(){
        Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(textLine);
        while(matcher.find()){
            text.add(matcher.group(1));
        }
        return text;
    }

    public ArrayList<Sentence> editText(){
        ArrayList<Sentence> editedText = new ArrayList<>();
        for (int sentence = 0; sentence < text.size(); sentence++) {
            editedText.add(new Sentence(text.get(sentence)).editedSentence());
        }
        return editedText;
    }

    public ArrayList<Sentence> splitToQuestionSentences(){
        ArrayList<Sentence> questions = new ArrayList<>();
        for (String line:text) {
            if(line.contains("?")){
                questions.add(new Sentence(line));
            }
        }
        return questions;
    }

}
