package controller;


import controller.action.Action;
import controller.action.ActionFactory;
import controller.action.teller.TellerActions;
import model.dao.DAOFactory;
import model.dao.entities.CheckDAO;
import model.dao.entities.ProductDAO;
import service.CheckService;
import service.Service;
import utils.RequestHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Controller", urlPatterns = "/main")
public class Controller extends HttpServlet {

    //RequestHelper requestHelper = RequestHelper.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String role = request.getParameter("role");
        String actionRequest = request.getParameter("command");
        ActionFactory actionFactory = ActionFactory.getActionFactory(role);
        Action action = actionFactory.getAction(actionRequest);
        page = action.execute(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
        /*Service service = new Service();
        PrintWriter printWriter = response.getWriter();
        printWriter.println(service.login("Bogdan", "teller123", "teller"));*/
    }

    public void run(){
        /*String role = "teller";
        String actionRequest = "login";
        ActionFactory actionFactory = ActionFactory.getActionFactory(role);
        System.out.println(actionFactory.getClass());
        Action action = actionFactory.getAction(actionRequest);
        System.out.println(action.getClass());*/
        CheckService service = new CheckService();
        //System.out.println(service.getAll());
        System.out.println("Canceled checks!!!");
        System.out.println(service.getCanceledChecks());

    }


}
