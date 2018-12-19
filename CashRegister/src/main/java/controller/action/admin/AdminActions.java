package controller.action.admin;

import controller.action.Action;
import controller.action.DefaultAction;
import controller.action.LogoutAction;
import controller.action.LoginAction;

public enum AdminActions {
    CANCEL_CHECK("",new CancelCheckAction()),
    CANCEL_PRODUCT("",new CancelProductAction()),
    LOGIN("login", new LoginAction()),
    LOGOUT("", new LogoutAction()),
    DEFAULT("",new DefaultAction());

    Action action;
    String page;

    AdminActions(String page, Action action){
        this.page = page;
        this.action = action;
    }

    public Action getAction(){
        return action;
    }

    public String getPage(){
        return page;
    }
}
