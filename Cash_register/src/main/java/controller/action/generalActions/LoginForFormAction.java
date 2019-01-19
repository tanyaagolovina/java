package controller.action.generalActions;

import controller.action.Action;
import model.User;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LoginForFormAction implements Action {

    private Service service;

    public LoginForFormAction(){
        service = new Service();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<String> messages = new ArrayList<>();
        String page;
        User adminUser = service.login(request.getParameter("username"), request.getParameter("password"), "admin");
        if(adminUser != null) {
            session.setAttribute("adminUser", adminUser);
        } else {
            messages.add(messageManager.getProperty("WRONG_DATA"));
            messages.add(messageManager.getProperty("TRY_AGAIN"));
            request.setAttribute("messages", messages);
        }
        switch (request.getParameter("role")) {
            case "teller" : page = configurationManager.getProperty("open_check"); break;
            case "specialist" : page = configurationManager.getProperty("main_specialist"); break;
            default: page = configurationManager.getProperty("error");
        }
        return page;
    }
}
