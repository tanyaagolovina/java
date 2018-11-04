package controller;

import model.Dictionary;
import services.InputUtility;
import services.Translator;
import view.OutputMessages;
import view.View;


public class Implementation {


    private enum Input {
        SHOW_DICTIONARY("1"), ADD_WORD("2"), TRANSLATE_LINE("3");
        String ordinal;
        Input(String ordinal){
            this.ordinal = ordinal;
        }
    }

    public static void implement(String input, Dictionary model){

        if(input.equals(Input.SHOW_DICTIONARY.ordinal)) {
            new View().printDictionary(model.getDictionary());
        } else if(input.equals(Input.ADD_WORD.ordinal)){
            model.addWord(getEnglishWord(), getTranslatedWord());
        } else if(input.equals(Input.TRANSLATE_LINE.ordinal)){
            View.printMessage(translate(model));
        }

    }

    private static String getEnglishWord(){
        View.printMessage(OutputMessages.ENTER_WORD);
        return InputUtility.getWord();
    }

    private static String getTranslatedWord(){
        View.printMessage(OutputMessages.TRANSLATION);
        View.printMessage(OutputMessages.ENTER_WORD);
        return InputUtility.getTranslate();
    }

    private static String translate(Dictionary model){
        View.printMessage(OutputMessages.ENTER_LINE);
        String line = InputUtility.getLine();
        return Translator.translate(line, model);
    }
}
