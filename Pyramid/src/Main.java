import com.tg.PyramidController.PyramidController;
import com.tg.PyramidModel.PyramidModel;
import com.tg.PyramidView.PyramidView;

public class Main {
    public static void main(String[] args){
        PyramidModel model = new PyramidModel();
        PyramidView view = new PyramidView();
        PyramidController controller = new PyramidController(model,view);
        controller.buildPyramid();

    }
}
