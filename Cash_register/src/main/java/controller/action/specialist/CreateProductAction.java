package controller.action.specialist;

import controller.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProductAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("messageList");
        request.getSession().removeAttribute("product");
        return configurationManager.getProperty("create_product");
    }
}
