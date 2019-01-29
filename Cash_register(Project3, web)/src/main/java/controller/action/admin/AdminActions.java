package controller.action.admin;

import controller.action.Action;
import controller.action.generalActions.DefaultAction;
import controller.action.generalActions.LogoutAction;
import controller.action.generalActions.LoginAction;
import controller.action.generalActions.ReturnAction;

public enum  AdminActions {
    CANCEL_CHECK(new CancelCheckAction()),
    CANCEL_PRODUCT(new CancelProductAction()),
    GET_ALL_CHECKS(new GetAllChecksAction()),
    GET_CANCELED_CHECKS(new GetCanceledChecks()),
    VIEW_CHECK(new ViewCheckAction()),
    LOGIN(new LoginAction()),
    LOGOUT(new LogoutAction()),
    RETURN(new ReturnAction()),
    DEFAULT(new DefaultAction());

    Action action;

    AdminActions(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }

}
