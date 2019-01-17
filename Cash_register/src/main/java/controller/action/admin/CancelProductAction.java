package controller.action.admin;

import controller.action.Action;
import model.Check;
import model.User;
import service.CheckService;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CancelProductAction implements Action {
    private CheckService checkService;

    public  CancelProductAction(){
        checkService = new CheckService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("check");
        Check check = checkService.cancelProduct((int)session.getAttribute("check_ID"), Integer.valueOf(request.getParameter("productID")));
        if(check.getProducts().size() == 0) {
            check = null;
        }
        session.setAttribute("check", check);
        session.removeAttribute("adminUser");
        return configurationManager.getProperty("open_check");
    }
}
