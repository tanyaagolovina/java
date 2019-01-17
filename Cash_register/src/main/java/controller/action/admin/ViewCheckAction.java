package controller.action.admin;

import controller.action.Action;
import model.Check;
import service.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewCheckAction implements Action {

    private CheckService checkService;

    public ViewCheckAction(){
        checkService = new CheckService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("check");
        Check check = checkService.getByID(Integer.valueOf(request.getParameter("checkID")));
        session.setAttribute("check", check);
        return configurationManager.getProperty("check");
    }
}
