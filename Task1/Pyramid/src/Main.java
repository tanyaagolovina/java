import com.tg.PyramidController.PyramidController;

import com.tg.PyramidView.PyramidView;
import model.PyramidModel;

public class Main {
    public static void main(String[] args){
        PyramidView view = new PyramidView();
        PyramidModel model = new PyramidModel();
        PyramidController controller = new PyramidController(model,view);
        controller.buildPyramid();

    }
}
