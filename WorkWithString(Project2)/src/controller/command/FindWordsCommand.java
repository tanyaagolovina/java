package controller.command;

import model.Sentence;
import model.Text;
import services.InputUtility;
import view.OutputMessages;

import java.util.ArrayList;

public class FindWordsCommand implements Command{
    @Override
    public void execute(Text text) {
        ArrayList<Sentence> questions = text.splitToQuestionSentences();
        view.printMessage(OutputMessages.ENTER_LENGTH);
        int length = InputUtility.getInt();
        view.printMessage(OutputMessages.WORDS_WITH_LENGTH);
        for (int sentence = 0; sentence < questions.size(); sentence++) {
            view.printMessage("Sentence - " + questions.get(sentence));
            view.printArrayList(questions.get(sentence).findWordsWithExactLength(length));
        }
    }
}
