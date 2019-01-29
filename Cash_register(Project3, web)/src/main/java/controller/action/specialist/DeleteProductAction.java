package controller.action.specialist;

import controller.action.Action;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DeleteProductAction implements Action {

    private ProductService productService;

    public DeleteProductAction(){
        productService = new ProductService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("messageList");
        ArrayList<String> messageList = new ArrayList<>();
        boolean flag = false;
        int productID = Integer.valueOf(request.getParameter("productID"));
        if (productService.ifProductExist(productID)){
            flag = productService.deleteProduct(productID);
        } else {
            messageList.add(messageManager.getProperty("PRODUCT_ERROR_LIST"));
        }
        if(flag) {
            messageList.add(messageManager.getProperty("PRODUCT_WAS_DELETED"));
        } else {
            messageList.add(messageManager.getProperty("CAN_NOT_DELETE"));
        }
        session.removeAttribute("adminUser");
        session.setAttribute("messageList", messageList);
        return configurationManager.getProperty("delete_product");
    }
}
