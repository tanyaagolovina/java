package controller.action.teller;

import controller.action.Action;
import controller.action.DefaultAction;
import controller.action.LogoutAction;
import controller.action.LoginAction;

public enum TellerActions {
    OPEN_CHECK(new OpenCheckAction()),
    ADD_PRODUCT(new AddProductAction()),
    CLOSE_CHECK(new CloseCheckAction()),
    LOGIN(new LoginAction()),
    LOGOUT(new LogoutAction()),
    DEFAULT(new DefaultAction());

    Action action;

    TellerActions(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
