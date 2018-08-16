package provider;

import actions.ActionApprove;
import actions.ActionRethink;
import actions.ActionSubmit;
import config.Events;
import config.States;
import java.util.EnumSet;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;

public class StateMachineProvider {

    public static StateMachine<States, Events> getDefaultStateMachine() {

        try {

            Builder<States, Events> builder = StateMachineBuilder.builder();

            builder.configureStates()
                  .withStates()
                  .initial(States.S1)
                  .end(States.S3)
                  .states(EnumSet.allOf(States.class));

            builder.configureTransitions()
                  .withExternal()
                    .source(States.S1)
                    .target(States.S2)
                    .event(Events.APPROVE)
                    .action(new ActionApprove())
                  .and()
                  .withExternal()
                    .source(States.S2)
                    .target(States.S3)
                     .event(Events.SUBMIT)
                     .action(new ActionSubmit())
                  .and()
                  .withExternal()
                     .source(States.S2)
                     .target(States.S1)
                     .event(Events.RETHINK)
                     .action(new ActionRethink());

            return builder.build();

        } catch (Exception e) {

            System.out.println("Exception verschluckt wie ein echter Hacker.");
            return null;
        }
    }
}