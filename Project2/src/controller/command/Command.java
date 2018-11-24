package controller.command;

import model.Text;
import services.FileReader;
import view.View;

public interface Command {

    //Text text = new Text(new FileReader().readText());
    View view = new View();

   void execute(Text text);
}
