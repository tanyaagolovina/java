import com.tg.PyramidController.PyramidController;

import com.tg.PyramidView.PyramidView;

public class Main {
    public static void main(String[] args){
        PyramidView view = new PyramidView();
        PyramidController controller = new PyramidController(view);
        controller.buildPyramid();

    }
}
