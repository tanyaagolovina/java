import com.tg.MatrixController.MatrixController;
import com.tg.MatrixModel.MatrixModel;
import com.tg.MatrixView.MatrixView;


public class Main {
    public static void main(String[] args){
        MatrixModel model = new MatrixModel();
        MatrixView view = new MatrixView();
        MatrixController controller = new MatrixController(model,view);
        controller.runMatrix();
    }
}

