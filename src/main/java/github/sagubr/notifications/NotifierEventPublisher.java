package github.sagubr.notifications;

import github.sagubr.entities.Notification;
import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class NotifierEventPublisher {

    private final ApplicationEventPublisher<NotifierEvent> publisher;

    public void publish(Notification notification) {
        publisher.publishEvent(new NotifierEvent(notification));
    }

}
