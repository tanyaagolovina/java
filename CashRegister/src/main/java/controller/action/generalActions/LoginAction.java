package controller.action;

import model.User;
import service.Service;
import utils.RequestUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginAction implements Action {
    private Service service;

    public LoginAction(){
        service = new Service();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        RequestUser requestUser = RequestUser.fromRequestParameters(request);
        requestUser.setAsRequestAttributes(request);
        List violations = requestUser.validate();
        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
            return "/";
        } else {
            User user = service.login(request.getParameter("username"), request.getParameter("password"), request.getParameter("role"));
            if (user != null) {
                request.getSession(false).setAttribute("user", user);
                return "/WEB-INF/view/main.jsp";
            }
        }
        return "/WEB-INF/view/errors/error.jsp";
    }
}
