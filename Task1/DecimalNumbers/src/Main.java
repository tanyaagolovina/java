import com.tg.decimalnumberscontroller.DecimalNumbersController;
import com.tg.decimalnumbersmodel.DecimalNumbersModel;
import com.tg.decimalnumbersview.DecimalNumbersView;

public class Main {
    public static void main(String[] args){
        DecimalNumbersView view = new DecimalNumbersView();
        DecimalNumbersModel model = new DecimalNumbersModel();
        DecimalNumbersController controller = new DecimalNumbersController(model,view);
        controller.translate();
    }
}
