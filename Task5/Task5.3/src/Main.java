import controller.Controller;
import model.Dictionary;
import view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new View(), new Dictionary()).run();
    }
}
