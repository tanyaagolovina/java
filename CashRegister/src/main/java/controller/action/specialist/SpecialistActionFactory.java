package controller.action.specialist;

import controller.action.Action;
import controller.action.ActionFactory;


public class SpecialistActionFactory extends ActionFactory {
    public Action getAction(String parameter){
        return defineAction(parameter).getAction();
    }

    private SpecialistActions defineAction(String action) {
        SpecialistActions neededAction = null;
        for (SpecialistActions act:SpecialistActions.values()) {
            if(act.toString().toLowerCase().matches(action)) neededAction = act;
            else return SpecialistActions.DEFAULT;
        }
        return neededAction;
    }

}
