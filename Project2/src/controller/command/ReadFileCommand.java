package controller.command;
import model.Text;
import view.OutputMessages;
import view.View;

public class ReadFileCommand implements Command {

    @Override
    public void execute(Text text) {
        view.printMessage(OutputMessages.READ_FILE);
        view.printArrayList(text.editText());
    }
}
