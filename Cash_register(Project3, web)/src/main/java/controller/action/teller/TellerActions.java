package controller.action.teller;

import controller.action.Action;
import controller.action.generalActions.*;

public enum TellerActions {
    OPEN_CHECK(new OpenCheckAction()),
    ADD_PRODUCT(new AddProductAction()),
    CLOSE_CHECK(new CloseCheckAction()),
    LOGIN(new LoginAction()),
    LOGOUT(new LogoutAction()),
    RETURN (new ReturnAction()),
    LOGIN_FORM(new LoginForFormAction()),
    DEFAULT(new DefaultAction());

    Action action;

    TellerActions(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
