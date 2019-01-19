package controller.action.specialist;

import controller.action.Action;
import controller.action.DefaultAction;
import controller.action.LogoutAction;
import controller.action.LoginAction;

public enum SpecialistActions {
    CREATE_PRODUCT(new CreateProductAction()),
    CREATE_REPORT(new CreateReportAction()),
    LOGIN(new LoginAction()),
    LOGOUT(new LogoutAction()),
    DEFAULT(new DefaultAction());

    Action action;

    SpecialistActions(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
