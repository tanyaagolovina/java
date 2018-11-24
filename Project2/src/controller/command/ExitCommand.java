package controller.command;

import model.Text;
import view.OutputMessages;

public class ExitCommand implements Command{
    @Override
    public void execute(Text text) {
        view.printMessage(OutputMessages.EXIT);
    }
}
