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
        commandManager.getCommand().execute(text);
    }

    private CommandManager defineMenuOperation(int number) {
        CommandManager[] itemsMenu = CommandManager.values();
        if (number < 0 || number >= itemsMenu.length) {
            return CommandManager.DEFAULT;
        }
        return itemsMenu[number];
    }
}
