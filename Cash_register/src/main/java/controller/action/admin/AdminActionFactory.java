package controller.action.admin;

import controller.action.Action;
import controller.action.ActionFactory;

public class AdminActionFactory extends ActionFactory {

    public Action getAction(String parameter){
        return defineAction(parameter).getAction();
    }

    private AdminActions defineAction(String action) {
        AdminActions neededAction = AdminActions.DEFAULT;
        for (AdminActions act:AdminActions.values()) {
            if(act.toString().equalsIgnoreCase(action)) neededAction = act;
        }
        return neededAction;
    }
}
