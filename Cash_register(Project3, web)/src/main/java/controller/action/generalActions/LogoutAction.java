package controller.action.generalActions;

import controller.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return configurationManager.getProperty("login");
    }
}
