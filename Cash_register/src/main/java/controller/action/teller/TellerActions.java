package controller.action.teller;

import controller.action.Action;
import controller.action.generalActions.DefaultAction;
import controller.action.generalActions.LogoutAction;
import controller.action.generalActions.LoginAction;
import controller.action.generalActions.ReturnAction;

public enum TellerActions {
    OPEN_CHECK("",new OpenCheckAction()),
    ADD_PRODUCT("",new AddProductAction()),
    CLOSE_CHECK("",new CloseCheckAction()),
    LOGIN("login",new LoginAction()),
    LOGOUT("",new LogoutAction()),
    RETURN ("", new ReturnAction()),
    LOGIN_FORM("", new LoginForFormAction()),
    DEFAULT("error",new DefaultAction());

    Action action;
    String page;

    TellerActions(String page, Action action){
        this.page = page;
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
