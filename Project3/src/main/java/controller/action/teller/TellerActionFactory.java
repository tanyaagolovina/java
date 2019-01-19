package controller.action.teller;

import controller.action.Action;
import controller.action.ActionFactory;
import controller.action.specialist.SpecialistActions;

public class TellerActionFactory extends ActionFactory {
    public Action getAction(String parameter){
        return defineAction(parameter).getAction();
    }

    private TellerActions defineAction(String action) {
        TellerActions neededAction = null;
        for (TellerActions act:TellerActions.values()) {
           if(act.toString().toLowerCase().matches(action)) neededAction = act;
           else return TellerActions.DEFAULT;
        }
        return neededAction;
    }
}
