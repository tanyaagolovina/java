package utils;

import model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestUser {
    private User user;

    private RequestUser(String username, String password, String role){
        this.user = new User(username, password, role);
    }

    public static RequestUser fromRequestParameters(
            HttpServletRequest request) {
        return new RequestUser(
                request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("role"));
    }

    public void setAsRequestAttributes(HttpServletRequest request){
        request.setAttribute("username", user.getUsername());
        request.setAttribute("password", user.getPassword());
        request.setAttribute("role", user.getRole());
    }

    public List<String> validate(){
        List<String> violations = new ArrayList<>();
        if(!Validator.isValidInput(user.getUsername()) && !Validator.isValidInput(user.getPassword())) {
            violations.add("Enter data");
        }
        if(!Validator.isValidRole(user.getRole())){
            violations.add("Wrong data!");
        }
        return violations;
    }
}
