package controller.action.generalActions;

import controller.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReturnAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("check");
        return configurationManager.getProperty("views") + request.getParameter("role") + configurationManager.getProperty("main");
    }
}
