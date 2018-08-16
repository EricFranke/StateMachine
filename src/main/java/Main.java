import config.Events;
import config.States;
import java.util.Map;
import listener.StateMachineListener;
import provider.StateMachineProvider;
import org.springframework.statemachine.StateMachine;

public class Main {

    public static void main(String[] args) {

        StateMachine<States, Events> stateMachine = StateMachineProvider.getDefaultStateMachine();
        stateMachine.addStateListener(new StateMachineListener());

        Map<Object, Object> variables = stateMachine.getExtendedState().getVariables();
        variables.put("name","TEST_6");
        variables.put("transitionCounter",0);

        stateMachineDemo1(stateMachine);
    }

    private static void stateMachineDemo1(StateMachine<States, Events> stateMachine) {

        stateMachine.start();
        stateMachine.sendEvent(Events.APPROVE);
        stateMachine.sendEvent(Events.SUBMIT);
        stateMachine.stop();
    }

    private static void stateMachineDemo2(StateMachine<States, Events> stateMachine) {

        stateMachine.start();
        stateMachine.sendEvent(Events.SUBMIT);
        stateMachine.stop();
    }
}