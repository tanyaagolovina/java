package controller.command;

import model.Text;
import services.CommandManager;

public class Macros implements Command {

    private int input;

    public Macros(int input){
        this.input = input;
    }

    @Override
    public void execute(Text text) {
        CommandManager commandManager = defineMenuOperation(input-1);
        switch (commandManager) {
            case READ_FILE:
                commandManager.getCommand().execute(text);
                break;
            case FIND_QUESTIONS:
                commandManager.getCommand().execute(text);
                break;
            case FIND_WORDS:
                commandManager.getCommand().execute(text);
                break;
            case DEFAULT:
                commandManager.getCommand().execute(text);
                break;
            case EXIT:
                commandManager.getCommand().execute(text);
        }
    }

    private CommandManager defineMenuOperation(int number) {
        CommandManager[] itemMenus = CommandManager.values();
        if (number < 0 || number >= itemMenus.length) {
            return CommandManager.DEFAULT;
        }
        return itemMenus[number];
    }
}
