import controller.ToysController;
import model.ToysRoom;
import view.ToysView;

public class Main {
    public static void main(String[] args) {
        new ToysController(new ToysRoom(), new ToysView()).run();
    }
}
