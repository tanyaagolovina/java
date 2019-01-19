package controller.action;

import controller.action.admin.AdminActionFactory;
import controller.action.specialist.SpecialistActionFactory;
import controller.action.teller.TellerActionFactory;

public abstract class ActionFactory {

    public static ActionFactory getActionFactory(String role){
        switch (role) {
            case "admin" : return new AdminActionFactory();
            case "teller" : return new TellerActionFactory();
            case "specialist" : return new SpecialistActionFactory();
            default:return null;
        }
    }
    public abstract Action getAction(String action);
}
