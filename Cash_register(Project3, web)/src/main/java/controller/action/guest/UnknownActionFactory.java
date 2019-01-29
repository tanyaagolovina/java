package controller.action.guest;

import controller.action.Action;
import controller.action.ActionFactory;
import controller.action.generalActions.DefaultAction;

public class UnknownActionFactory extends ActionFactory {
    @Override

    public Action getAction(String action) {
        return defineAction(action).getAction();
    }

    private GuestActions defineAction(String action) {
        GuestActions neededAction = GuestActions.DEFAULT;
        for (GuestActions act:GuestActions.values()) {
            if(act.toString().equalsIgnoreCase(action)) neededAction = act;
        }
        return neededAction;
    }
}
