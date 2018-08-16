package actions;

import config.Events;
import config.States;
import org.springframework.statemachine.StateContext;

public class CommonActionFunctions {

    protected void incrementTransitionCounter(StateContext<States, Events> stateContext) {

        int transitionCounter = (int) stateContext
              .getExtendedState()
              .getVariables()
              .get("transitionCounter");

        stateContext.getExtendedState().getVariables().put("transitionCounter", ++transitionCounter);
    }

    protected void printTransitionCounter(StateContext<States, Events> stateContext) {

        int transitionCounter = (int) stateContext
              .getExtendedState()
              .getVariables()
              .get("transitionCounter");

        System.out.println("Transitions: " + transitionCounter);
    }

    protected String getName(StateContext<States, Events> stateContext) {
        return (String) stateContext.getExtendedState().getVariables().get("name");
    }

    protected int getTransitionCounter(StateContext<States, Events> stateContext) {
        return (int) stateContext.getExtendedState().getVariables().get("transitionCounter");
    }
}
