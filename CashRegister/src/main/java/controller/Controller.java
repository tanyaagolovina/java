package controller;


import controller.action.Action;
import controller.action.ActionFactory;
import controller.action.teller.TellerActions;
import model.dao.DAOFactory;
import model.dao.entities.CheckDAO;
import model.dao.entities.ProductDAO;
import utils.RequestHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Controller", urlPatterns = "/main")
public class Controller extends HttpServlet {

    //RequestHelper requestHelper = RequestHelper.getInstance();
    public Controller() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String role = request.getParameter("role");
        String actionRequest = request.getParameter("command");
        ActionFactory actionFactory = ActionFactory.getActionFactory(role);
        Action action = actionFactory.getAction(actionRequest);
        page = action.execute(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }



    /*public void run(){
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ProductDAO productDAO = mySQLFactory.getProductDAO();
        CheckDAO checkDAO = mySQLFactory.getCheckDao();
        //productDAO.addProduct(566, "kinder surprise", 30, 450);
        System.out.println(productDAO.getAll());
        //productDAO.updateProduct(35, 566);
        //System.out.println(productDAO.getAllProducts());
        System.out.println("Check!!!!!!!!!!!!!!!!");
        //int checkID = checkDAO.openCheck();
        //System.out.println(checkDAO.addProductToCheck(checkID, 122, 11));
        //System.out.println(checkDAO.addProductToCheck(checkID, 1, 1));
        int check = 11;
        System.out.println(checkDAO.getByID(check));
        System.out.println(checkDAO.cancelProductInCheck(check, 4));
        System.out.println(checkDAO.getByID(check));
    }*/


}
