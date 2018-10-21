import controller.StoreController;
import model.StoreModel;
import view.StoreView;

public class Main {
    public static void main(String[] args){
        new StoreController(new StoreModel(), new StoreView()).run();
    }
}
