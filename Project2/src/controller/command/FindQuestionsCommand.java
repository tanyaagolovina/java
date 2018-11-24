package controller.command;

import model.Text;
import view.OutputMessages;
import view.View;

public class FindQuestionsCommand implements Command{
    @Override
    public void execute(Text text) {
        view.printMessage(OutputMessages.QUESTIONS);
        view.printArrayList(text.splitToQuestionSentences());
    }
}
