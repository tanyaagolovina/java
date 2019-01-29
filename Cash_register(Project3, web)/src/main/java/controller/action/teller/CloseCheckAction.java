package controller.action.teller;

import controller.action.Action;
import model.Check;
import service.CheckService;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CloseCheckAction implements Action {

    private CheckService service;
    private ProductService productService;

    public CloseCheckAction(){
        service = new CheckService();
        productService = new ProductService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Check check = (Check)session.getAttribute("check");
        ArrayList<String> errorList = new ArrayList<>();
        if (check == null) {
            errorList.add(messageManager.getProperty("CHECK_IS_EMPTY"));
            session.setAttribute("error_list", errorList);
        }
        return configurationManager.getProperty("check");
    }
}
