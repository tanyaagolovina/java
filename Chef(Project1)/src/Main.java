import controller.CookController;
import model.Menu;
import view.CookView;

public class Main {
    public static void main(String[] args){
        new CookController(new CookView(), new Menu()).run();
    }
}
