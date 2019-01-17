package controller.action.admin;

import controller.action.Action;
import model.Check;
import service.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CancelCheckAction implements Action {

    CheckService checkService;

    public CancelCheckAction(){
        checkService = new CheckService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        checkService.cancelCheck((int)session.getAttribute("check_ID"));
        session.removeAttribute("check");
        session.removeAttribute("adminUser");
        return configurationManager.getProperty("views") + "teller" + configurationManager.getProperty("main");
    }
}
