package services;

import controller.command.*;

public enum CommandManager {
    READ_FILE(new ReadFileCommand()),
    FIND_QUESTIONS(new FindQuestionsCommand()),
    FIND_WORDS(new FindWordsCommand()),
    EXIT(new ExitCommand()),
    DEFAULT(new DefaultCommand());


    private Command command;

    CommandManager(Command command){
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
