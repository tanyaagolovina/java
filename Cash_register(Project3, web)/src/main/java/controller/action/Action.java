package controller.action;

import utils.managers.ConfigurationManager;
import utils.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    ConfigurationManager configurationManager = ConfigurationManager.INSTANCE;
    MessageManager messageManager = new MessageManager();
    String execute(HttpServletRequest request, HttpServletResponse response);
}
