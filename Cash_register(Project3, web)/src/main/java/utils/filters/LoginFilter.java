package utils.filters;

import model.User;
import utils.managers.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/WEB-INF/views/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        ConfigurationManager manager = ConfigurationManager.INSTANCE;
        if(user == null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(manager.getProperty("login"));
            dispatcher.forward(request, response);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
