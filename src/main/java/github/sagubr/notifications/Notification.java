package github.sagubr.notifications;

import io.micronaut.context.event.ApplicationEvent;
import lombok.Getter;

@Getter
public class Notification extends ApplicationEvent {

    private final String recipient;
    private final String message;

    public Notification(Object source, String recipient, String message) {
        super(source);
        this.recipient = recipient;
        this.message = message;
    }
}


