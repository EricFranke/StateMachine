package actions;

import config.Events;
import config.States;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class ActionRethink extends CommonActionFunctions implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> stateContext) {
        incrementTransitionCounter(stateContext);
    }
}