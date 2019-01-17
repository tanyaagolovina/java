package controller.action.specialist;

import controller.action.Action;
import model.entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddNewProductAction implements Action {

    private ProductService productService;

    public AddNewProductAction(){
        productService = new ProductService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("messageList");
        int productID = Integer.valueOf(request.getParameter("productID"));
        ArrayList<String> messageList = new ArrayList<>();
        if (!productService.ifProductExist(productID)){
            Product product = productService.createProduct(productID, request.getParameter("productName"),
                    Double.valueOf(request.getParameter("price")), Integer.valueOf(request.getParameter("amount")));
            session.setAttribute("product", product);
            messageList.add(messageManager.getProperty("PRODUCT_WAS_ADDED"));
        } else {
            messageList.add(messageManager.getProperty("IS_ALREADY_EXIST"));
        }
        session.setAttribute("messageList", messageList);
        return configurationManager.getProperty("create_product");
    }
}
