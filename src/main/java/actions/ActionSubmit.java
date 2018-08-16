package actions;

import config.Events;
import config.States;
import dao.StateMachineDao;
import entity.ProcessImpl;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class ActionSubmit extends CommonActionFunctions implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> stateContext) {

        incrementTransitionCounter(stateContext);

        String name = getName(stateContext);
        int transitionCounter = getTransitionCounter(stateContext);

        ProcessImpl process = new ProcessImpl(name, transitionCounter);
        StateMachineDao.persist(process);
    }
}
