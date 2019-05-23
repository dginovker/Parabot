package Strategies;


import Actions.Action;
import Actions.ActionHandler;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;

/**
 * Created by SRH on 1/15/2018.
 */
public class RunLoop implements Strategy {
    private ArrayList<Action> actions;
    private ActionHandler actionHandler;

    public RunLoop(ArrayList<Action> actions)
    {
        this.actions = actions;
        actionHandler = new ActionHandler();
    }

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public void execute() {
        for (Action line : actions)
        {
            switch (line.getAction())
            {
                case "Interact with":
                    actionHandler.handleInteractWith(line);
                    break;
                case "Use item on":
                    actionHandler.useItemOn(line);
                    break;
                case "Type":
                    actionHandler.type(line);
                    break;
                case "Click (x,y)":
                    actionHandler.clickxy(line);
                    break;
                default:
                    System.out.println("Error: Unimplemented action: " + line.getAction());
            }
        }
    }
}
