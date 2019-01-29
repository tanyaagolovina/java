package controller.action.guest;

import controller.action.Action;
import controller.action.generalActions.DefaultAction;
import controller.action.generalActions.LoginAction;

public enum GuestActions {
    LOGIN(new LoginAction()),
    DEFAULT(new DefaultAction());

    Action action;

    GuestActions(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
