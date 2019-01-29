import controller.Controller;
import model.Text;
import view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new View(), new Text()).run();
    }
}
