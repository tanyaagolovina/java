package controller.action.generalActions;

import controller.action.Action;
import model.User;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LoginAction implements Action {

    private Service service;

    public LoginAction(){
        service = new Service();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        User user = service.login(request.getParameter("username"), request.getParameter("password"), request.getParameter("role"));
        if (user != null) {
            page = configurationManager.getProperty("views") + request.getParameter("role") + configurationManager.getProperty("main");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            ArrayList<String> messages = new ArrayList<>();
            messages.add(messageManager.getProperty("WRONG_DATA"));
            messages.add(messageManager.getProperty("TRY_AGAIN"));
            request.setAttribute("messages", messages);
            page = configurationManager.getProperty("login");
        }
        return page;

    }
}
