package github.sagubr.notifications;

import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class NotifierEventPublisher {

    private final ApplicationEventPublisher<NotifierEvent> publisher;

    public void publish(String recipient, String message) {
        publisher.publishEvent(new NotifierEvent(recipient, message));
    }

}
