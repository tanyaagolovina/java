package controller.action.specialist;

import controller.action.Action;
import controller.action.generalActions.DefaultAction;
import controller.action.generalActions.LogoutAction;
import controller.action.generalActions.LoginAction;

public enum SpecialistActions {
    CREATE_PRODUCT("",new CreateProductAction()),
    CREATE_REPORT("",new CreateReportAction()),
    LOGIN("login",new LoginAction()),
    LOGOUT("",new LogoutAction()),
    DEFAULT("error",new DefaultAction());

    Action action;
    String page;

    SpecialistActions(String page, Action action){
        this.page = page;
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
