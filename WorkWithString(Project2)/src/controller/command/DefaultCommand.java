package controller.command;

import model.Text;
import view.OutputMessages;

public class DefaultCommand implements Command {
    @Override
    public void execute(Text text) {
        view.printMessage(OutputMessages.WRONG_INPUT);
    }
}
