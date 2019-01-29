package controller.action.specialist;

import controller.action.Action;
import controller.action.ActionFactory;


public class SpecialistActionFactory extends ActionFactory {
    public Action getAction(String parameter){
        return defineAction(parameter).getAction();
    }

    private SpecialistActions defineAction(String action) {
        SpecialistActions neededAction = SpecialistActions.DEFAULT;
        for (SpecialistActions act:SpecialistActions.values()) {
            if(act.toString().equalsIgnoreCase(action)) neededAction = act;
        }
        return neededAction;
    }

}
