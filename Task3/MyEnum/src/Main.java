import controller.Controller;
import model.MyEnum;
import view.View;

public class Main {
    public static void main(String[] args){
        new Controller(new MyEnum<>(), new View()).run();
    }
}
