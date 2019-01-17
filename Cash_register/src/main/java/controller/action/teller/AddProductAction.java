package controller.action.teller;

import controller.action.Action;
import service.CheckService;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddProductAction implements Action {
    private CheckService service;
    private ProductService productService;

    public AddProductAction(){
        service = new CheckService();
        productService = new ProductService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("error_list");
        int checkID = (int)session.getAttribute("check_ID");
        int productID = Integer.valueOf(request.getParameter("productID"));
        int amount = Integer.valueOf(request.getParameter("amount"));
        ArrayList<String> productErrorList = new ArrayList<>();
        boolean flag = false;
        if(productService.ifProductExist(productID)) {
            flag = service.addProductToCheck(checkID, productID, amount);
        } else {
            productErrorList.add(messageManager.getProperty("PRODUCT_ERROR_LIST"));
        }
        if(flag){
            session.setAttribute("check", service.getByID(checkID));
        } else {
            productErrorList.add(messageManager.getProperty("NOT_IN_STOCK"));
        }
        session.setAttribute("product_error_list", productErrorList);
        return configurationManager.getProperty("open_check");
    }
}
