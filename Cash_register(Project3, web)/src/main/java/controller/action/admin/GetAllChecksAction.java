package controller.action.admin;

import controller.action.Action;
import model.Check;
import service.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllChecksAction implements Action {

    private CheckService checkService;

    public GetAllChecksAction(){
        checkService = new CheckService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int recordsPerPage = 3;
        int currentPage;
        currentPage = Integer.valueOf(request.getParameter("currentPage"));
        List<Check> checks = checkService.getAll(currentPage, recordsPerPage);
        int rows = checkService.getAllRows();
        int nOfPages = rows / recordsPerPage;
        if(nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        request.setAttribute("nOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        session.setAttribute("checks", checks);
        return configurationManager.getProperty("checks");
    }
}
