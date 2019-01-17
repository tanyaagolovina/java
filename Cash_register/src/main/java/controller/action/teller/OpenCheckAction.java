package controller.action.teller;

import controller.action.Action;
import service.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OpenCheckAction implements Action {
    private CheckService service;

    public OpenCheckAction(){
        service = new CheckService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int check_ID = service.openCheck();
        if(check_ID != 0) {
            HttpSession session = request.getSession();
            session.setAttribute("check_ID", check_ID);
            return configurationManager.getProperty("open_check");
        }
        return configurationManager.getProperty("error");
    }
}
