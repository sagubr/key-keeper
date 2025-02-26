package github.sagubr.notifications;

import github.sagubr.entities.Reservation;
import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class NotifierEventPublisher {

    private final ApplicationEventPublisher<NotifierEvent> publisher;

    public void publish(Reservation reservation, String message) {
        publisher.publishEvent(new NotifierEvent(reservation, message));
    }

}
