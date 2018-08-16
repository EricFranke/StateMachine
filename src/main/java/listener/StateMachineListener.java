package listener;

import config.Events;
import config.States;
import org.springframework.messaging.Message;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;

public class StateMachineListener extends StateMachineListenerAdapter<States, Events> {

    @Override
    public void eventNotAccepted(Message<Events> event) {
        System.out.println("Event not accepted.");
    }


}
