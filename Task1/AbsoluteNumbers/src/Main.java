import com.tg.AbsoluteNumbersController.AbsoluteNumbersController;
import com.tg.AbsoluteNumbersModel.AbsoluteNumbersModel;
import com.tg.AbsoluteNumbersView.AbsoluteNumbersView;

public class Main {
    public static void main(String[] args){
        AbsoluteNumbersModel model = new AbsoluteNumbersModel();
        AbsoluteNumbersView view = new AbsoluteNumbersView();
        AbsoluteNumbersController number = new AbsoluteNumbersController(model,view);
        number.findNumbers();
    }
}
