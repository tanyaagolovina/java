package model;

import model.entity.Sign;
import model.entity.Space;
import model.entity.Word;
import java.util.ArrayList;

public class Sentence {

    private ArrayList<Word> words = new ArrayList<>();
    private Sign sign;
    private Space space;
    private String line;

    public Sentence(String line){
        this.line = line;
    }

    public Sentence(){

    }


    public Sentence editedSentence(){
        space = new Space();
        space.defineRegex();
        return new Sentence(line.replaceAll(space.getRegex(), " "));
    }

    private void splitToWords(){
        String[] wwords = line.split("[\\s,:?.!]+");
        for (String word: wwords) {
            words.add(new Word(word));
        }
    }

    public ArrayList<Word> findWordsWithExactLength(int length){
        splitToWords();
        ArrayList<Word> foundedWords = new ArrayList<>();
        for (int word = 0; word < words.size(); word++) {
            if(words.get(word).length() == length) {
                if(!isWordAlreadyAdded(foundedWords, words.get(word))) {
                    foundedWords.add(words.get(word));
                }
            }
        }
        return foundedWords;
    }

    private boolean isWordAlreadyAdded(ArrayList<Word> words, Word word){
        boolean flag = false;
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).equals(word)) flag = true;
        }
        return flag;
    }

    public ArrayList<Word> getWords(){
        splitToWords();
        return words;
    }

    @Override
    public String toString() {
        return line;
    }
}
