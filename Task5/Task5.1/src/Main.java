import controller.Controller;
import model.Students;

public class Main {
    public static void main(String[] args){
        new Controller(new Students()).run();
    }
}
