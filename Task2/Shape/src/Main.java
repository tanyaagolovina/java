import controller.Controller;
import model.Shapes;
import view.ShapesView;

public class Main {
    public static void main(String[] args){
        new Controller(new Shapes(), new ShapesView()).run();
    }
}
