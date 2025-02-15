package github.sagubr.notifications;

import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;


@Singleton
@RequiredArgsConstructor
public class NotificationPublisher {

    private final ApplicationEventPublisher<Notification> publisher;

    public void publish(String recipient, String message) {
        publisher.publishEvent(new Notification(this, recipient, message));
    }
}
