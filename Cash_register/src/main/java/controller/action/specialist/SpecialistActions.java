package controller.action.specialist;

import controller.action.Action;
import controller.action.generalActions.*;

public enum SpecialistActions {
    CREATE_PRODUCT(new CreateProductAction()),
    CREATE_REPORT(new CreateReportAction()),
    ADD_NEW_PRODUCT(new AddNewProductAction()),
    DELETE_PRODUCT(new DeleteProductAction()),
    LOGIN_FORM(new LoginForFormAction()),
    LOGIN(new LoginAction()),
    LOGOUT(new LogoutAction()),
    RETURN(new ReturnAction()),
    DEFAULT(new DefaultAction());

    Action action;

    SpecialistActions(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
}
