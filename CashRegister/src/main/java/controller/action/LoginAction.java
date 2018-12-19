package controller.action;

import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {
    private Service service = new Service();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        boolean login = service.login(request.getParameter("username"), request.getParameter("password"), request.getParameter("role"));
        if(login) return "view/main";
        else return "view/error";
    }
}
